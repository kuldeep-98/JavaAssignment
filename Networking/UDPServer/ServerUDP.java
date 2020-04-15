import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class ServerUDP {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(7777);
        Scanner read = new Scanner(System.in);
        while (true){
            byte[] buff = new byte[100];
            DatagramPacket data = new DatagramPacket(buff,buff.length);
            socket.receive(data);
            String strData = new String(buff);
            System.out.println("Receives: " +strData);
            if (strData.equalsIgnoreCase("exit"))
                break;
            String response = read.nextLine();
            byte[] resData = response.getBytes();
            DatagramPacket responsePacket = new DatagramPacket(resData,resData.length,data.getAddress(),data.getPort());
            socket.send(responsePacket);
        }
    }
}
