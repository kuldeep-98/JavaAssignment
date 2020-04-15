import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{
        Scanner read = new Scanner(System.in);
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getLocalHost();
        String data;
        do {
	    System.out.println("Enter numbers to sort \nor type exit to exit");
            data = read.nextLine();
            byte[] buff = data.getBytes();
            DatagramPacket packet = new DatagramPacket(buff,buff.length,inetAddress,7777);
            socket.send(packet);
            if (data.equals("exit"))
                break;
            byte[] response = new byte[1000];
            DatagramPacket responsePacket = new DatagramPacket(response,response.length);
            socket.receive(responsePacket);
            String responseData = new String(response);
            System.out.println("Sorted Array By Server:"+responseData + "\n\n");
        }while (!data.equals("exit"));
    }
}
