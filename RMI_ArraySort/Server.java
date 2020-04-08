import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Server {
    public static void main(String[] args) {
        try {
            Adder stub = new AdderRemote();
            Naming.rebind("rmi://localhost:7000/soon",stub);
        }catch (RemoteException | MalformedURLException e){
            System.out.println(e.getMessage());
        }
    }
}
