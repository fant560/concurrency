package chapter9.monitoring_fork_join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {
        ForkJoinPool pool = new ForkJoinPool();
        int[] array = new int[10_000];
        Task task1 = new Task(array, 0, array.length);
        pool.execute(task1);

        while (!task1.isDone()) {
            showLog(pool);
            TimeUnit.SECONDS.sleep(1);
        }

        pool.shutdown();

        pool.awaitTermination(1, TimeUnit.DAYS);

        showLog(pool);
        System.out.println("Main: End of the program");
    }

    private static void showLog(ForkJoinPool pool) {
        System.out.println("***************");
        System.out.println("Main: Fork/Join Pool log");
        // уровень параллелизма
        System.out.printf("Main: Fork/Join Pool: Parallelism: %d\n", pool.getParallelism());
        // количество рабочих потоков внутри ForkJoinPool
        System.out.printf("Main: Fork/Join Pool: Pool Size: %d\n", pool.getPoolSize());
        // количество потоков в данный момент выполняющих задания
        System.out.printf("Main: Fork/Join Pool: Active Thread Count: %d\n", pool.getActiveThreadCount());
        // количество рабочих незаблокированных в данный момент потоков
        System.out.printf("Main: Fork/Join Pool: Running Thread Count: %d\n", pool.getRunningThreadCount());
        // количество заданий, которые были подписаны, но еще не начали выполнение
        System.out.printf("Main: Fork/Join Pool: Queued Submission: %d\n", pool.getQueuedSubmissionCount());
        // количество подписанных и уже хапущенных заданий
        System.out.printf("Main: Fork/Join Pool: Queued Tasks: %d\n", pool.getQueuedTaskCount());
        // есть ли подписанные задания, которые еще не начали выполнение
        System.out.printf("Main: Fork/Join Pool: Queued Submissions: %s\n", pool.hasQueuedSubmissions());
        // количество заданий у рабочих потоков, полученных из других потоков
        System.out.printf("Main: Fork/Join Pool: Steal Count: %d\n", pool.getStealCount());
        // закончено ли выполнение
        System.out.printf("Main: Fork/Join Pool: Terminated: %s\n", pool.isTerminated());
        System.out.println("***************");
    }

}
