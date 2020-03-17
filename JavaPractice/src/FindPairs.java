import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindPairs {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int pairs = 0;
        Set<Integer> color= new HashSet<>();
        for(int i = 0; i<ar.length;i++){
            if(!color.contains(ar[i])) {
                color.add(ar[i]);
            }
            else {
                pairs++;
                color.remove(ar[i]);
            }
        }
        return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        System.out.println(result);

        scanner.close();
    }
}
