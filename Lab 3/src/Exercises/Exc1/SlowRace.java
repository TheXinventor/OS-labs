package Exercises.Exc1;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Objects;

public class SlowRace {

    public static void main(String args []) throws Exception {
        MyThread.count = 0;
        MyThread.turn = "";
        MyThread.interested = new Hashtable<>();
        MyThread.interested.put("A", false);
        MyThread.interested.put("B", false);

        MyThread thread1 = new MyThread();
        thread1.name = "A";
        thread1.other = "B";

        MyThread thread2 = new MyThread();
        thread2.name = "B";
        thread2.other = "A";

        thread1.start();
        thread2.start();
        thread2.join();
        thread1.join();
        System.out.println("MyThread.count = " + MyThread.count);
    }
}

class MyThread extends Thread {
    volatile static int count;
    String name;
    String other;
    volatile static String turn;
    volatile static Dictionary<String, Boolean> interested;

    public void run() {
        for(int i = 0 ; i < 10 ; i++) {
            delay();

            // Peterson's Algorithm
            interested.put(name, true);
            turn = other;
            while (interested.get(other) && Objects.equals(turn, other)) {
                delay();
            }
            // Critical section start
            int x = count;
            System.out.println("Thread " + name + " read " + x);
            delay();
            count = x + 1;
            System.out.println("Thread " + name + " wrote " + (x + 1));
            //Critical section end
            interested.put(name, false);
        }
    }

    void delay() {
        int delay = (int) (1000 * Math.random());
        try {
            Thread.sleep(delay);
        }
        catch(Exception e) {
        }
    }
}

