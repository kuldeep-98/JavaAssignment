package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XOR {
    public static void main(String[] args) {

        int t, n;
        Scanner read = new Scanner(System.in);
        t = read.nextInt();
        int[] result = new int[t];
        for (int i = 0; i <t ; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        List<List<Integer>> array = new ArrayList<>();
        while (t != 0) {
            t--;
            n = read.nextInt();
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a.add(read.nextInt());
            }
            array.add(a);
        }
        int k = 0;
        for (List<Integer> ar:
             array) {
            for (int i = 0; i <ar.size() ; i++) {
                for (int j = i+1; j <ar.size() ; j++) {
                    int rs = ar.get(i)^ar.get(j);
                    if (rs<result[k]) result[k]= rs;
                }
            }
            System.out.println(result[k]);
            k++;
        }
    }
}
