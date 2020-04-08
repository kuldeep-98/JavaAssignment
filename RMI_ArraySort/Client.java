import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Scanner read = new Scanner(System.in);
            List<Integer> arr = new ArrayList<>();
            Adder stub= (Adder) Naming.lookup("rmi://localhost:7000/soon");
            System.out.println("Enter size of array");
            int size = read.nextInt();
            System.out.println("Enter " + size +" elements");

            for (int i = 0; i <size ; i++) {
                arr.add(read.nextInt());
            }

            System.out.println(arr);
	    System.out.println("Array After Sort");	
            System.out.println(stub.ArraySort(arr));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
