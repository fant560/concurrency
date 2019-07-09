package chapter4.cancel_executor_task;

import java.util.concurrent.Callable;

//184 страница
public class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        while (true){
            System.out.print("Task: Test\n");
            Thread.sleep(100);
        }
    }

}
