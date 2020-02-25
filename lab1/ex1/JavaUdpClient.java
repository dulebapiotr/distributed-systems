import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class JavaUdpClient {

    public static void main(String args[]) throws Exception
    {
        System.out.println("JAVA UDP CLIENT");
        DatagramSocket socket = null;
        int portNumber = 9008;

        try {
            //sending message to server
            socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName("localhost");
            byte[] sendBuffer = "Buenos Dias Muczos Gracias".getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address, portNumber);
            socket.send(sendPacket);

            //receiving message from server
            DatagramPacket receivePacket = new DatagramPacket(sendBuffer, sendBuffer.length);
            socket.receive(receivePacket);
            String received = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received message: " + received);
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
