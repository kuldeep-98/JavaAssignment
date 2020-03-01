package com.company;

import static com.company.ThreadColor.ANSI_RED;

public class AnotherThread extends Thread{
    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from Another Thread" + currentThread().getName());

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("Another Thread woke me up");
        }
        System.out.println(ANSI_RED+"After 3 sec i'm here");
    }
}
