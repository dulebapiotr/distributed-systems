
import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Agency_B {

    public static void main(String[] argv) throws Exception {

        // info
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Agency Name: ");
        String agencyName = br.readLine();

        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();


        // exchange
        String ORDER_EXCHANGE_NAME = "cargo_exchange";
        String ORDER_ACK_EXCHANGE_NAME = "ack_exchange";
        String ADMIN_EXCHANGE_NAME = "admin_exchange";

        channel.exchangeDeclare(ORDER_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        channel.exchangeDeclare(ORDER_ACK_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        channel.exchangeDeclare(ADMIN_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        String ackQueueName = channel.queueDeclare(agencyName+"_ack_queue", false, false, false, null).getQueue();
        String adminQueueName = channel.queueDeclare(agencyName+"_admin_queue_carrier", false, false, false, null).getQueue();

        channel.queueBind(ackQueueName, ORDER_ACK_EXCHANGE_NAME, agencyName);
        channel.queueBind(adminQueueName, ADMIN_EXCHANGE_NAME, "AGENCY.#");

        System.out.println("Created queue: " + ackQueueName);
        System.out.println("Created queue: " + adminQueueName);

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("Received :" + message);
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        channel.basicConsume(ackQueueName, false, consumer);
        channel.basicConsume(adminQueueName, false, consumer);

        int orderID = 1;

        while (true) {
            System.out.println("Enter cargo type: ");
            String key = br.readLine();

            // read msg
            System.out.println("Enter cargo info: ");
            String info = br.readLine();
            String message = agencyName+":"+ Integer.toString(orderID++)+":"+info;

            // break condition
            if ("exit".equals(message)) {
                break;
            }

            // publish
            channel.basicPublish(ORDER_EXCHANGE_NAME, key, null, message.getBytes("UTF-8"));
            System.out.println("Sent: " + message);
        }
    }
}

