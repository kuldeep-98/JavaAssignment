package com.company;

import java.util.Scanner;

public class Beakers {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int T= read.nextInt();
        for (int i = 0; i <T ; i++) {
            long N = read.nextLong();
            long K = read.nextLong();
            long day = 1;
            long count = 1;
            long beaker = 0;
            long Nbeaker =0;
            int exceed = 1;
            long AmCpunt;
            while (true){
                count *= 2;
                if (count==0){
                    count++;
                }
                if (count<N) {
                    beaker = beaker + count;
                }else {
                    count = 0;
                    Nbeaker = N *exceed;
                    exceed++;
                }
                AmCpunt = Nbeaker+count;
                day++;
                if (K<=AmCpunt){
                    break;
                }
            }
            System.out.println(day);
        }
    }
}
