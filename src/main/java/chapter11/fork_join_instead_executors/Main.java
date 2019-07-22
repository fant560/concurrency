package chapter11.fork_join_instead_executors;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[100_000];

        Task task = new Task(array);

        ExecutorService service = Executors.newCachedThreadPool();

        Date start, end;

        start = new Date();
        service.execute(task);
        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        end = new Date();

        System.out.printf("Main: Executor: %d\n", end.getTime() - start.getTime());


        TaskFJ taskFJ = new TaskFJ(array, 0, array.length);
        ForkJoinPool pool = new ForkJoinPool();
        start = new Date();
        pool.execute(taskFJ);
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        end = new Date();
        System.out.printf("Main: Fork/Join: %d\n", end.getTime() - start.getTime());

    }

}
