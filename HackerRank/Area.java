import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Area {

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        int max = 1;
        char[] ch = word.toCharArray();
        for (int i = 0; i <ch.length ; i++) {
            for (int j = i; j <ch.length ; j++) {
                int m;
                m = Math.max (h[ch[i]-97],h[ch[j]-97]);
                max = Math.max(m,max);
            }
        }
        return max*ch.length;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);
        System.out.println(result);
        scanner.close();
    }
}
