package chapter11.managing_thread_with_executors;

public class Task implements Runnable {

    @Override
    public void run(){
        int r;
        for (int i = 0; i < 1_000_000; i++){
            r = 0;
            r++;
            r++;
            r *= r;
        }
    }

}
