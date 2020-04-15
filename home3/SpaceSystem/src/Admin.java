
import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Admin {

    public static void main(String[] argv) throws Exception {

        // info
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("ADMIN PANEL ");

        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // exchange
        String ADMIN_EXCHANGE_NAME = "admin_exchange";

        String CARGO_EXCHANGE_NAME = "cargo_exchange";
        String ORDER_ACK_EXCHANGE_NAME = "ack_exchange";
        channel.exchangeDeclare(CARGO_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        channel.exchangeDeclare(ORDER_ACK_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        channel.exchangeDeclare(ADMIN_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        String cargoQueueName = channel.queueDeclare("cargo_to_admin", false, false, false, null).getQueue();
        String ackQueueName = channel.queueDeclare("ack_to_admin", false, false, false, null).getQueue();

        channel.queueBind(cargoQueueName, CARGO_EXCHANGE_NAME, "#");
        channel.queueBind(ackQueueName, ORDER_ACK_EXCHANGE_NAME, "#");
        System.out.println("Created queue: " + cargoQueueName);

        // consumer (message handling)
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(message);
                channel.basicAck(envelope.getDeliveryTag(), false);

            }
        };


        channel.basicConsume(cargoQueueName,false,consumer);
        channel.basicConsume(ackQueueName,false,consumer);





        while (true) {
            System.out.println("Enter destionation: ");
            String key = br.readLine();
            System.out.println("Enter message: ");
            String message = br.readLine();
            switch (key){
                case "all":{
                    channel.basicPublish(ADMIN_EXCHANGE_NAME, "AGENCY.CARRIER", null, message.getBytes("UTF-8"));
                    break;
                }
                case "agency":{
                    channel.basicPublish(ADMIN_EXCHANGE_NAME, "AGENCY", null, message.getBytes("UTF-8"));
                    break;
                }
                case "carrier":{
                    channel.basicPublish(ADMIN_EXCHANGE_NAME, "CARRIER", null, message.getBytes("UTF-8"));
                    break;
                }
            }
            System.out.println("Sent: " + message);


            // break condition
            if ("exit".equals(message)) {
                break;
            }
        }
    }
}

