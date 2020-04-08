import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
import java.util.List;

public class AdderRemote extends UnicastRemoteObject implements Adder {

    protected AdderRemote() throws RemoteException {
        super();
    }

    @Override
    public List<Integer> ArraySort(List<Integer> arr) throws RemoteException {
        Collections.sort(arr);
        return arr;
    }
}
