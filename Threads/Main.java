package com.company;


import static com.company.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_BLUE + "Hello From the main thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("==Another==");
        anotherThread.setPriority(Thread.MAX_PRIORITY);
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_PURPLE + "Hello from the anonymous");
            }

        }.start();
        Thread myRunnable = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_CYAN + "Main Runnable Anonymous");
            }
        });
        try {
            Thread.sleep(2000);
            System.out.println(ANSI_BLUE+Thread.currentThread().getName());
        }catch (InterruptedException e){}
        myRunnable.start();
        System.out.println(ANSI_BLUE + "Hello again from main");
    }
}
