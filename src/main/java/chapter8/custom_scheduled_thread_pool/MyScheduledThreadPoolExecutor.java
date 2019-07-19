package chapter8.custom_scheduled_thread_pool;

import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {

    public MyScheduledThreadPoolExecutor(int corePoolSize){
        super(corePoolSize);
    }

    @Override
    protected <V>RunnableScheduledFuture<V> decorateTask(
            Runnable runnable, RunnableScheduledFuture<V> task){
        return new MyScheduledTask<>(runnable, null, task, this);
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initDelay, long period, TimeUnit unit){
        ScheduledFuture<?> task = super.scheduleAtFixedRate(command, initDelay, period, unit);
        MyScheduledTask<?> myTask = (MyScheduledTask<?>)task;
        myTask.setPeriod(TimeUnit.MILLISECONDS.convert(period, unit));
        return task;
    }

}
