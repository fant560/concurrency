package chapter10.monitoring_thread_class;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {
        Task task = new Task();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(task);
            threads[i].setPriority(i + 1);
            threads[i].start();
        }
        for (int j = 0; j < 10; j++) {
            System.out.println("Main: Logging threads");
            for (int i = 0; i < threads.length; i++) {
                System.out.println("*********************");
                System.out.printf("Main: %d: Id: %d Name: %s: Priority: %d\n", i,
                        threads[i].getId(), threads[i].getName(), threads[i].getPriority());
                System.out.printf("Main: Status: %s\n", threads[i].getState());
                System.out.printf("Main: Thread Group: %s\n", threads[i].getThreadGroup());
                System.out.println("Main: Stack Trace");
                for (int t = 0; t < threads[i].getStackTrace().length; t++) {
                    System.out.printf("Main: %s\n", threads[i].getStackTrace()[t]);
                }
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
