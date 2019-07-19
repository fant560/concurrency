package chapter8.custom_thread_factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CustomExecutorMain {

    public static void main(String[] args) throws Exception {
        MyThreadFactory threadFactory = new MyThreadFactory("MyThreadFactory");

        ExecutorService executor = Executors.newCachedThreadPool(threadFactory);

        MyTask task = new MyTask();
        executor.submit(task);

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);

        System.out.print("Main: End of the program.\n");
    }

}
