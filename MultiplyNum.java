import java.util.Scanner;

public class MultiplyNum {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int num1, num2, rem1, rem2;
        int arr[][] = new int[4][4];
	System.out.println("Enter Two Numbers");
        num1 = read.nextInt();
        num2 = read.nextInt();
        arr[2][0] = rem1 = num1 % 10;
        arr[0][2] = rem2 = num2 % 10;
        arr[1][0] = num1 - rem1;
        arr[0][1] = num2 - rem2;
        for (int i = 1; i < 4; i++) {
            int sum = 0;
            for (int j = 1; j < 4; j++) {
                if (j == arr[i].length - 1) {
                    arr[i][j] = sum;
                } else {
                    arr[i][j] = arr[0][j] * arr[i][0];
                    sum += arr[i][j];
                }
                if (i == arr[i].length - 1) {
                    arr[i][j] = arr[i - 2][j] + arr[i - 1][j];
                }
            }
        }
        for (int[] x : arr) {
            for (int e : x) {
                System.out.print(e + "\t");
            }
            System.out.println();
        }
    }
}
