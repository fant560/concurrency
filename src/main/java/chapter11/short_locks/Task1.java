package chapter11.short_locks;

import java.util.concurrent.locks.Lock;

public class Task1 implements Runnable {

    private final Lock lock;

    public Task1(Lock lock){
        this.lock = lock;
    }

    @Override
    public void run(){
        lock.lock();
        Operations.readData();
        Operations.processData();
        Operations.writeData();
        lock.unlock();
    }

}
