package com.company;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int sea = 0;
        int flag = 0;
        int v = 0;
        char[] vally = s.toCharArray();
        for (char ch:
             vally) {
            switch (ch){
                case 'U':
                    sea++;
                    flag = 2;
                    break;
                case 'D':
                    sea--;
                    flag = 1;
                    break;
            }
            if (flag==2&&sea==0)
                v++;
        }
        System.out.println(v);
        return v;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

       // bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
