package chapter10.fork_join_exceptions;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class OneSecondLongTask extends RecursiveAction {

    @Override
    protected void compute(){
        System.out.println("Task: Starting");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Task: Finish");
    }

}
