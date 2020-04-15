import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(7777);
        while (true){
	    System.out.println("Server is ready");
            byte[] buff = new byte[1000];
            DatagramPacket packet = new DatagramPacket(buff,buff.length);
            socket.receive(packet);
            String data = new String(buff);
            String[] string = data.trim().split(" ");
            if (string[0].equals("exit"))
                break;
            int[] list = new int[string.length];
            int i = 0;
            for (String s:
                    string) {
                list[i++] = Integer.parseInt(s);
            }
            Arrays.sort(list);
            StringBuilder s = new StringBuilder();
            for (int li:
                    list) {
                s.append(li + " ");
            }
            buff = s.toString().getBytes();
            DatagramPacket responsePacket = new DatagramPacket(buff,buff.length,packet.getAddress(),packet.getPort());
            socket.send(responsePacket);
        }
    }
}
