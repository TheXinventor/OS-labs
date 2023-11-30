package Excercises.Exc1;

public class MultiParallelPi extends Thread {

    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();

        MultiParallelPi[] threads = new MultiParallelPi[numThreads];

        for (int i=0; i<numThreads; i++) {
            threads[i] = new MultiParallelPi();
            threads[i].begin = threadSize * i;
            threads[i].end = threadSize * (i+1);
        }

        threads[numThreads-1].end = numSteps;

        for (MultiParallelPi thread : threads) thread.start();
        for (MultiParallelPi thread : threads) thread.join();

        double pi = 0.0;
        for (MultiParallelPi thread : threads) pi += thread.sum;
        pi *= step;

        long endTime = System.currentTimeMillis();

        System.out.println("Value of pi: " + pi);

        System.out.println("Calculated in " +
                (endTime - startTime) + " milliseconds");
    }

    static int numSteps = 10000000;

    static int numThreads = 4;

    static int threadSize = numSteps / numThreads;

    static double step = 1.0 / (double) numSteps;


    double sum ;
    int begin, end ;


    public void run() {


        sum = 0.0 ;


        for(int i = begin ; i < end ; i++){
            double x = (i + 0.5) * step ;
            sum += 4.0 / (1.0 + x * x);
        }
    }
}
