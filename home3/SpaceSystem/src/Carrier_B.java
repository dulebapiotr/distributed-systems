import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Carrier_B {

    public static void main(String[] argv) throws Exception {

        // info
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Carrier Name: ");
        String carrierName = br.readLine();

        System.out.println("Enter 1/2 cargo type : ");
        String cargoType1 = br.readLine();
        System.out.println("Enter 2/2 cargo type : ");
        String cargoType2 = br.readLine();

        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();
        //channel.basicQos(1,false);

        // exchange
        String CARGO_EXCHANGE_NAME = "cargo_exchange";
        String ORDER_ACK_EXCHANGE_NAME = "ack_exchange";
        String ADMIN_EXCHANGE_NAME = "admin_exchange";

        channel.exchangeDeclare(CARGO_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        channel.exchangeDeclare(ORDER_ACK_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        channel.exchangeDeclare(ADMIN_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);



        String keyCargoType1 = cargoType1;
        String keyCargoType2 = cargoType2;

        // queue & bind
        String cargoQueueName1 = channel.queueDeclare(cargoType1, false, false, false, null).getQueue();
        channel.queueBind(cargoQueueName1, CARGO_EXCHANGE_NAME, keyCargoType1);
        System.out.println("Created queue: " + cargoQueueName1);

        String cargoQueueName2 = channel.queueDeclare(cargoType2, false, false, false, null).getQueue();
        channel.queueBind(cargoQueueName2, CARGO_EXCHANGE_NAME, keyCargoType2);
        System.out.println("Created queue: " + cargoType2);

        String adminQueueName = channel.queueDeclare(carrierName+"_admin_queue_carrier", false, false, false, null).getQueue();
        channel.queueBind(adminQueueName, ADMIN_EXCHANGE_NAME, "#.CARRIER");
        System.out.println("Created queue: " + adminQueueName);








        // consumer (message handling)
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                String[] data = message.split(":");
                System.out.println("Received order from: "+data[0]);
                System.out.println("OrderID: "+data[1]);
                System.out.println("Info: "+data[2]);
                int timeToSleep = (int)(Math.random() * ((10 - 2) + 1)) + 2;
                try {
                    Thread.sleep(timeToSleep * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Processed: " + message);
                channel.basicAck(envelope.getDeliveryTag(), false);
                channel.basicPublish(ORDER_ACK_EXCHANGE_NAME, data[0],null, ("ACK :"+message).getBytes("UTF-8"));


            }
        };

        Consumer adminConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(message);
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };


        // start listening
        System.out.println("Waiting for messages...");
        channel.basicConsume(cargoQueueName1, false, consumer);
        channel.basicConsume(cargoQueueName2, false, consumer);
        channel.basicConsume(adminQueueName, false, adminConsumer);
    }
}
