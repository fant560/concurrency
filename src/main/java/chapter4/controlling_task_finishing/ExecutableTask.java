package chapter4.controlling_task_finishing;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutableTask implements Callable<String> {

    private final String name;

    public String getName(){return name;}

    public ExecutableTask(String name){
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        try {
            long duration = (long)(Math.random() * 10);
            System.out.printf("%s: Waiting %d seconds for results.\n",
                    this.name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException ignored){

        }
        return "Hello, world! I'm" + name;
    }

}
