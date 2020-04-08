import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Adder extends Remote {
    public List<Integer> ArraySort(List<Integer> arr) throws RemoteException;
}
