import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        Scanner read = new Scanner(System.in);
        InetAddress inetAddress = InetAddress.getLocalHost();
        String dataStr;
        do{
            dataStr = read.nextLine();
            byte[] buff = dataStr.getBytes();
            DatagramPacket packet = new DatagramPacket(buff,buff.length,inetAddress,7777);
            socket.send(packet);
            if (dataStr.equalsIgnoreCase("exit"))
                break;
            byte[] response = new byte[1024];
            DatagramPacket packetReceive = new DatagramPacket(response,response.length);
            socket.receive(packetReceive);
            System.out.println("From server: " + new String(response));
        }while (!dataStr.equalsIgnoreCase("exit"));
    }
}
