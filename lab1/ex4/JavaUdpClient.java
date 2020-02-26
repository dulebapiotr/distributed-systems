import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class JavaUdpClient {

    public static void main(String args[]) throws Exception
    {
        System.out.println("JAVA UDP CLIENT");
        DatagramSocket socket = null;
        int portNumber = 9011;

        byte[] receiveBuffer = new byte[1024];

        try {
            //sending message to server
            socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName("localhost");
            byte[] sendBuffer = "j".getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address, portNumber);
            socket.send(sendPacket);

            //receving message from server
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(receivePacket);
            String received = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println(received);
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