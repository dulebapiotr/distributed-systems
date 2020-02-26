import java.io.ByteArrayOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class JavaUdpServer {

    public static void main(String args[])
    {
        System.out.println("JAVA UDP SERVER");
        DatagramSocket socket = null;
        int portNumber = 9011;

        try{
            socket = new DatagramSocket(portNumber);
            byte[] receiveBuffer = new byte[1024];

            while(true) {
                Arrays.fill(receiveBuffer, (byte)0);
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);
                String msg = new String(receivePacket.getData());
                System.out.println("Received "+msg);
                if(msg.charAt(0)=="p".charAt(0)){
                    System.out.println("Pong Python");

                    InetAddress address = receivePacket.getAddress();
                    int port = receivePacket.getPort();
                    byte[] respondBuffer = "Pong Python".getBytes();
                    DatagramPacket respondPacket = new DatagramPacket(respondBuffer, respondBuffer.length, address,port);
                    socket.send(respondPacket);
                }
                if(msg.charAt(0)=="j".charAt(0)){
                    System.out.println("Pong Java");
                    receiveBuffer="Java Pong".getBytes();

                    InetAddress address = receivePacket.getAddress();
                    int port = receivePacket.getPort();
                    byte[] respondBuffer = "Pong Java".getBytes();
                    DatagramPacket respondPacket = new DatagramPacket(receiveBuffer, receiveBuffer.length, address,port);
                    socket.send(respondPacket);
                }
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
