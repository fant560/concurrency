package chapter8.custom_thread_factory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory implements ThreadFactory {
    private AtomicInteger counter;

    private String prefix;

    public MyThreadFactory(String prefix){
        this.prefix = prefix;
        counter = new AtomicInteger(1);
    }

    @Override
    public Thread newThread(Runnable r){
        return new MyThread(r, prefix + "-" + counter.getAndIncrement());
    }

}
