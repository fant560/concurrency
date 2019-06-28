package chapter1;

import java.util.concurrent.TimeUnit;

public class InterruptionExample {

    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        task.interrupt();

        System.out.printf("Main: Status of the Thread: %s\n",
                task.getState());
        System.out.printf("Main: isInterrupted: %s\n",
                task.isInterrupted());
        System.out.printf("Main: isAlive: %s\n", task.isAlive());


        FileSearch search = new FileSearch("/home/user/news/client", "angular.json");
        Thread thread = new Thread(search);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        thread.interrupt();


    }

}
