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
        int portNumber = 9010;

        try{
            socket = new DatagramSocket(portNumber);
            byte[] receiveBuffer = new byte[1024];

            while(true) {
                Arrays.fill(receiveBuffer, (byte)0);
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);
                int msg = new String(receivePacket.getData());

                ByteBuffer byteBuffer = ByteBuffer.allocate(4);
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                byteBuffer.putInt(msg);
                byte[] result = byteBuffer.array();

                System.out.println("received msg: " + Arrays.toString(result));

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