import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.net.InetAddress;

public class JavaUdpServer {

    public static void main(String args[])
    {
        System.out.println("JAVA UDP SERVER");
        DatagramSocket socket = null;
        int portNumber = 9010;

        try{
            socket = new DatagramSocket(portNumber);
            byte[] receiveBuffer = new byte[1024];

            while(true) {
                Arrays.fill(receiveBuffer, (byte)0);
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);
                //String msg = new String(receivePacket.getData());
                //System.out.println("received msg: " + msg);

        
                
                int nb = ByteBuffer.wrap(receiveBuffer).getInt();
                int reverse = Integer.reverseBytes(nb);
                System.out.println("received msg: " + Integer.toString(reverse));

                byte[] respondBuffer = ByteBuffer.allocate(4).putInt(reverse+1).array();
                InetAddress address = receivePacket.getAddress();
                int port = receivePacket.getPort();
                DatagramPacket respondPacket = new DatagramPacket(respondBuffer, respondBuffer.length, address,port);
                socket.send(respondPacket);

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