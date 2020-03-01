class ThreadColor {
    public static final String[] ANSI = {"\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[34m", "\u001B[36m"};
}

class Philosopher implements Runnable {
    private Object leftFork;
    private Object rightFork;
    private String color;
    private int i = 0;

    public Philosopher(Object leftFork, Object rightFork, String color) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.color = color;
    }

    public void doSomething(String something) {
        try {
            System.out.println(color + Thread.currentThread().getName() + something);
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void run() {
        try {
            doSomething(" Thinking");
            synchronized (leftFork) {
                doSomething(" PickUp Left Fork");
                synchronized (rightFork) {
                    doSomething(" PickUp Right Fork");
                    for (int i = 0; i < 2; i++) {
                        System.out.println(color + Thread.currentThread().getName() + " Eating");
                    }
                    doSomething(" Put Down Right Fork");
                }
                doSomething(" Put Down Left Fork");
            }
        } catch (Exception e) {
        }
    }
}

public class DiningPhilosopher {
    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Object[] fork = new Object[philosophers.length];

        for (int i = 0; i < fork.length; i++) {
            fork[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = fork[i];
            Object rightFork = fork[(i + 1) % fork.length];
            if (i == philosophers.length - 1)
                philosophers[i] = new Philosopher(rightFork, leftFork, ThreadColor.ANSI[i]);
            else philosophers[i] = new Philosopher(leftFork, rightFork, ThreadColor.ANSI[i]);
            new Thread(philosophers[i], "Philosopher " + (i + 1)).start();
        }

    }
}
