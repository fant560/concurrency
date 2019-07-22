package chapter10.runnable_with_result;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        FileSearch opt = new FileSearch("/opt","log");
        FileSearch home = new FileSearch("/home/user", "log");
        FileSearch var = new FileSearch("/var/log", "log");
        Task optTask = new Task(opt, null);
        Task homeTask = new Task(home, null);
        Task varTask = new Task(var, null);

        executor.submit(optTask);
        executor.submit(homeTask);
        executor.submit(varTask);

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.printf("Main: Opt Task: Number of Results: %d\n",
                    optTask.get().size());
            System.out.printf("Main: Home Task: Number of Results: %d\n",
                    homeTask.get().size());
            System.out.printf("Main: Var Task: Number of Results: %d\n",
                    varTask.get().size());
        } catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
    }

}
