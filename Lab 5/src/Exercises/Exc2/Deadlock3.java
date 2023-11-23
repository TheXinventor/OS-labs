package Exercises.Exc2;

import Experiments.Exp2.Deadlock2;

import java.util.concurrent.Semaphore;

public class Deadlock3 extends Deadlock2 {
    public static void main(String[] args) throws InterruptedException {
        MyThread threadA = new MyThread(
                "A",
                "R",
                "S",
                MyThread.semR,
                MyThread.semS
        );
        MyThread threadB = new MyThread(
                "B",
                "S",
                "T",
                MyThread.semS,
                MyThread.semT
        );
        MyThread threadC = new MyThread(
                "C",
                "T",
                "R",
                MyThread.semT,
                MyThread.semR
        );

        threadA.start();
        threadB.start();
        threadC.start();

        threadC.join();
        threadB.join();
        threadA.join();
    }
}

class MyThread extends Thread {

    static Semaphore semR = new Semaphore(1);
    static Semaphore semS = new Semaphore(1);
    static Semaphore semT = new Semaphore(1);

    String name;
    String sem1Name;
    String sem2Name;
    Semaphore sem1;
    Semaphore sem2;

    MyThread(
            String name,
            String sem1Name,
            String sem2Name,
            Semaphore sem1,
            Semaphore sem2
    ) {
        this.name = name;
        this.sem1Name = sem1Name;
        this.sem2Name = sem2Name;
        this.sem1 = sem1;
        this.sem2 = sem2;
    }

    public void run() {
        try {
            while(true) {
                delay() ;

                acquireAndPrint(sem1Name, sem1);
                delay();
                acquireAndPrint(sem2Name, sem2);
                delay();

                releaseAndPrint(sem1Name, sem1);
                delay();
                releaseAndPrint(sem2Name, sem2);
            }
        }
        catch(Exception e) {}
    }

    void delay() {
        int delay = (int) (1000 * Math.random());
        try {
            Thread.sleep(delay);
        }
        catch(Exception e) {
        }
    }

    void acquireAndPrint(String resourceName, Semaphore resource) throws InterruptedException {
        System.out.println("Thread " + name + " waiting for " + resourceName);
        resource.acquire();
        System.out.println("Thread " + name + " acquired " + resourceName);
    }

    void releaseAndPrint(String resourceName, Semaphore resource) {
        resource.release();
        System.out.println("Thread " + name + " released " + resourceName);
    }
}