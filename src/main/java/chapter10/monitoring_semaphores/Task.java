package chapter10.monitoring_semaphores;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

    private final Semaphore semaphore;

    public Task(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.printf("%s: Get the Semaphore.\n",
                    Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + ": Release the semaphore");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

}
