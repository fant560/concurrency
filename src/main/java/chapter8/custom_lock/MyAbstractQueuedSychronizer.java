package chapter8.custom_lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class MyAbstractQueuedSychronizer extends AbstractQueuedSynchronizer {

    private final AtomicInteger state;

    public MyAbstractQueuedSychronizer(){
        state = new AtomicInteger(0);
    }

    @Override
    protected boolean tryAcquire(int arg){
        return state.compareAndSet(0, 1);
    }

    @Override
    protected boolean tryRelease(int arg){
        return state.compareAndSet(1, 0);
    }

}
