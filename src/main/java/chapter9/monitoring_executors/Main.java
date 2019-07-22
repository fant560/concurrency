package chapter9.monitoring_executors;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Random random = new Random();
        for (int i = 0; i < 10; i++){
            Task task = new Task(random.nextInt(10000));
            executor.submit(task);
        }
        for (int i = 0; i < 5; i++){
            showLog(executor);
            TimeUnit.SECONDS.sleep(1);
        }

        executor.shutdown();

        for (int i = 0; i < 5; i++){
            showLog(executor);
            TimeUnit.SECONDS.sleep(1);
        }

        executor.awaitTermination(1, TimeUnit.DAYS);

        System.out.println("Main: End of the program");
    }

    private static void showLog(ThreadPoolExecutor executor){
        System.out.println("********************");
        System.out.println("Main: Executor Log");
        System.out.printf("Main: Executor: Core pool size: %d\n", executor.getCorePoolSize());
        System.out.printf("Main: Executor: Active Count: %d\n", executor.getActiveCount());
        System.out.printf("Main: Executor: Task Count: %d\n", executor.getTaskCount());
        System.out.printf("Main: Executor: Completed Task Count: %d\n", executor.getCompletedTaskCount());
        System.out.printf("Main: Executor: Shutdown: %s\n", executor.isShutdown());
        System.out.printf("Main: Executor: Terminating: %s\n", executor.isTerminating());
        System.out.printf("Main: Executor: Terminated: %s\n", executor.isTerminated());
        System.out.println("********************");
    }


}
