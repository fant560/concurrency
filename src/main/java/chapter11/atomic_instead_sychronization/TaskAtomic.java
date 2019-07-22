package chapter11.atomic_instead_sychronization;

import java.util.concurrent.atomic.AtomicInteger;

public class TaskAtomic implements Runnable {

    private final AtomicInteger number;

    public TaskAtomic(){
        this.number = new AtomicInteger();
    }

    @Override
    public void run(){
        for (int i = 0; i < 1_000_000; i++){
            number.set(i);
        }
    }


}
