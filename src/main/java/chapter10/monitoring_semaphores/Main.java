package chapter10.monitoring_semaphores;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {
        Semaphore semaphore = new Semaphore(3);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++){
            Task task = new Task(semaphore);
            threads[i] = new Thread(task);
            threads[i].start();

            TimeUnit.MILLISECONDS.sleep(200);
            showLog(semaphore);
        }
        for (int i = 0; i < 5; i++){
            showLog(semaphore);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    private static void showLog(Semaphore semaphore){
        System.out.println("********************");
        System.out.println("Main: Semaphore Log");
        // доступные ресурсы для семафора
        System.out.printf("Main: Semaphore: Available Permits: %d\n",
                semaphore.availablePermits());
        // есть ли задания в очереди
        System.out.printf("Main: Semaphore: Queued Threads: %s\n",
                semaphore.hasQueuedThreads());
        // количество потоков, ждущих освобождения ресурса
        System.out.printf("Main: Semaphore: Queue Length: %d\n",
                semaphore.getQueueLength());
        // активен ли справедливый метод(дольше всех ждущий поток первым получит ресурсы)
        System.out.printf("Main: Semaphore: Fairness: %s\n", semaphore.isFair());
        System.out.println("********************");
    }

}
