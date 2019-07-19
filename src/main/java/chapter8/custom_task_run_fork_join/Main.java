package chapter8.custom_task_run_fork_join;

import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) throws Exception {
        final int ARRAY_SIZE = 10_000;
        int[] array = new int[ARRAY_SIZE];
        ForkJoinPool pool = new ForkJoinPool();
        Task task = new Task("Task", array, 0, array.length);
        pool.invoke(task);
        pool.shutdown();
        System.out.println("Main: End of the program");
    }

}
