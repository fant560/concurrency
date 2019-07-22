package chapter11.fork_join_instead_executors;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

    private final int[] array;

    public Task(int[] array){
        this.array = array;
    }

    @Override
    public void run(){
        for (int i = 0; i < array.length; i++){
            array[i]++;
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
