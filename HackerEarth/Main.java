package com.company;

import java.util.Scanner;

public class Main {
    public static class Cal {
        public static long gcd(long a, long b) {
            int gcd = 1;
            for (int i = 1; i <= a && i <= b; i++) {
                if (a % i == 0 && b % i == 0)
                    gcd = i;
            }
            return gcd;
        }
    }

    public static void main(String[] args) {
        int x, y, p, q;
        long b1=1, b2=1, b3=1;
        long tx , ty, tp,tq ;
        Scanner read = new Scanner(System.in);
        tx = x = read.nextInt();
        ty = y = read.nextInt();
        tp = p = read.nextInt();
        tq = q = read.nextInt();
        while (tx != tp || ty != tq) {
            if (tx > tp) {
                if (tx % tp != 0) {
                    b3 = b3 * x;
                    b1 = b1 * p;
                } else b3 = b3 * (tx / tp);
            } else if (tx < tp) {
                if (tp % tx != 0) {
                    b3 = b3 * x;
                    b1 = b1 * p;
                } else b1 = b1 * (tp / tx);
            }
            ty = y * b2;
            tq = q * b3;
            if (ty > tq) {
                if (ty % tq != 0) {
                    b3 = b3 * y;
                    b2 = b2 * q;
                } else b3 = b3 * (ty / tq);
            } else if (ty < tq) {
                if (tq % ty != 0) {
                    b3 = b3 * y;
                    b2 = b2 * q;
                } else b2 = b2 * (tq / ty);
            }
            tx = x * b1;
            ty = y * b2;
            tp = p * b3;
            tq = q * b3;
        }
        if (b1%9==0&&b2%9==0&&b3%9==0) {
            b1 = b1/9;
            b2 = b2/9;
            b3 = b3/9;
        }
        if (b1%13==0&&b2%13==0&&b3%13==0) {
            b1 = b1/13;
            b2 = b2/13;
            b3 = b3/13;
        }
        if (b1%5==0&&b2%5==0&&b3%5==0) {
            b1 = b1/5;
            b2 = b2/5;
            b3 = b3/5;
        }
        if (b1%4==0&&b2%4==0&&b3%4==0) {
            b1 = b1/4;
            b2 = b2/4;
            b3 = b3/4;
        }
        if (b1%3==0&&b2%3==0&&b3%3==0) {
            b1 = b1/3;
            b2 = b2/3;
            b3 = b3/3;
        }
        if (b1%2==0&&b2%2==0&&b3%2==0) {
            b1 = b1/2;
            b2 = b2/2;
            b3 = b3/2;
        }

        System.out.println(b1 + " " + b2 + " " + b3);
    }
}
