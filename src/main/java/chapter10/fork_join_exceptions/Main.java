package chapter10.fork_join_exceptions;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        OneSecondLongTask task = new OneSecondLongTask();
        Handler handler = new Handler();

        ExceptionWorkerFactory factory = new ExceptionWorkerFactory();
        ForkJoinPool pool = new ForkJoinPool(2, factory, handler, false);

        pool.execute(task);

        pool.shutdown();

        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Task: Finish");
    }

}
