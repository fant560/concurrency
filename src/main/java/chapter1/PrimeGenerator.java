package chapter1;

import static chapter1.Calculator.isPrime;

public class PrimeGenerator extends Thread {

    @Override
    public void run() {
        long number = 1L;
        while (true) {
            if (isPrime(number)){
                System.out.printf("Number %d is Prime\n", number);
            }
            if (isInterrupted()){
                System.out.println("The prime generator has been interrupted");
                return;
            }
            number++;
        }
    }

}
