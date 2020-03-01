package com.company;

import static com.company.ThreadColor.ANSI_CYAN;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_CYAN+"Hello Form Runnable");
    }

}
