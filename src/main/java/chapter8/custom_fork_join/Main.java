package chapter8.custom_fork_join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {
        MyWorkerThreadFactory factory = new MyWorkerThreadFactory();
        ForkJoinPool pool = new ForkJoinPool(4, factory, null, false);
        final int ARRAY_SIZE = 100_000;
        int[] array = new int[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++){
            array[i] = i;
        }
        MyRecursiveTask task = new MyRecursiveTask(array, 0, array.length);
        pool.execute(task);
        task.join();
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.DAYS);
        System.out.printf("Main: Result: %d\n", task.get());
        System.out.print("Main: End of the program");
    }

}
