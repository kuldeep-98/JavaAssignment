
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Solution {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        System.out.println(password);
        final int len = 6;
        int reqLen = 4;
            if (password.matches(".*[a-z].*")) reqLen--;
            if (password.matches(".*[A-Z].*")) reqLen--;
            if (password.matches(".*[0-9].*")) reqLen--;
            if (password.matches(".*[^a-zA-Z0-9].*")) reqLen--;
            reqLen = Math.max(reqLen,6-n);
        System.out.println(reqLen);
        return reqLen;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        //bufferedWriter.write(String.valueOf(answer));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
