package com.company;

import java.util.Scanner;

public class BeautifulSq {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int N = read.nextInt();
        int[] A = new int[N];
        int count=0;
        for (int i = 0; i <N ; i++) {
            A[i] = read.nextInt();
        }

        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <N ; j++) {
                if (i!=j) {
                    for (int k = 0; k < N; k++) {
                        if (i!=k&&i!=j){
                            if (((A[i]|A[j]|A[k])== (A[i] & A[j] & A[k])))
                                if ((A[i] & A[j] & A[k]) ==(A[i]^A[j]^A[k]))
                                    count++;
                        }
                    }
                }
            }
        }
        System.out.println(count/2);
    }
}
