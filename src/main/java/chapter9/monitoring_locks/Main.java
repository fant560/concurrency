package chapter9.monitoring_locks;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {
        MyLock lock = new MyLock();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            Task task = new Task(lock);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0; i < 15; i++) {
            System.out.println("Main: Logging the Lock");
            System.out.println("********************");
            System.out.printf("Lock: Owner: %s\n", lock.getOwnerName());
            System.out.printf("Lock: Queued Threads: %s\n", lock.hasQueuedThreads());
            if (lock.hasQueuedThreads()) {
                System.out.printf("Lock: Queue Length: %d\n", lock.getQueueLength());
                System.out.println("Lock: Queued Threads: ");
                Collection<Thread> lockedThreads = lock.getThreads();
                for (Thread lockedThread : lockedThreads) {
                    System.out.printf("%d locked thread - %s\n", i, lockedThread.getName());
                }
                System.out.println();
            }
            System.out.printf("Lock: Fairness: %s\n", lock.isFair());
            System.out.printf("Lock: Locked %s\n", lock.isLocked());
            System.out.println("********************");
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
