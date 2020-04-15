package com.company;

import java.util.*;

public class Polygon {
    public static void main(String[] args) {
        int t, n;
        Scanner read = new Scanner(System.in);
        t = read.nextInt();
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
        for (List<Integer> ar:
                array) {
            int sum = 0;
            Collections.sort(ar);
            int max = ar.remove(ar.size()-1);
            for (int i:
                 ar) {
                sum+=i;
            }
            if (sum>max)
                System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
