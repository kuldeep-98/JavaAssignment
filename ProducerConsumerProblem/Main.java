package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;


public class Main {

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();
        Producer producer = new Producer(buffer, ThreadColor.ANSI_YELLOW, bufferLock);
        Consumer consumer1 = new Consumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);
        Consumer consumer2 = new Consumer(buffer, ThreadColor.ANSI_RED, bufferLock);
        Thread t1 = new Thread(consumer1);
        Thread t2 = new Thread(consumer2);
        t1.setName("Consumer 1");
        t2.setName("Consumer 2");
        t1.start();
        t2.start();
        new Thread(producer).start();
    }
}

class Producer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public Producer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] items = {"1", "2", "3", "4", "5"};

        for (String num : items) {
            try {
                System.out.println(color + "Adding..." + num);
                bufferLock.lock();
                buffer.add(num);
                bufferLock.unlock();
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        bufferLock.lock();
        buffer.add("EOF");
        bufferLock.unlock();
    }
}

class Consumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public Consumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        while (true) {
            bufferLock.lock();
            try {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals("EOF")) {
                    System.out.println(color + "Exit");
                    break;
                } else {
                    System.out.println(color + Thread.currentThread().getName() + " Removed item " + buffer.remove(0));
                }
            }finally {
                bufferLock.unlock();
            }
        }
    }
}
