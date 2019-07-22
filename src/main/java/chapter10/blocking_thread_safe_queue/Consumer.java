package chapter10.blocking_thread_safe_queue;

import java.util.concurrent.LinkedTransferQueue;

public class Consumer implements Runnable {

    private LinkedTransferQueue<String> buffer;

    private String name;

    public Consumer(String name, LinkedTransferQueue<String> buffer){
        this.name = name;
        this.buffer = buffer;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10_000; i++){
            try {
                buffer.take();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.printf("Consumer: %s: Consumer done\n", name);
    }



}
