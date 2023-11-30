package Experiments.Exp1;

public class SequentialPi {

    public static void main(String[] args) {

        int numSteps = 10000000;

        double step = 1.0 / (double) numSteps;

        double sum = 0.0;

        for(int i = 0 ; i < numSteps ; i++){
            double x = (i + 0.5) * step ;
            sum += 4.0 / (1.0 + x * x);
        }

        double pi = step * sum ;

        System.out.println("Value of pi: " + pi);
    }

}
