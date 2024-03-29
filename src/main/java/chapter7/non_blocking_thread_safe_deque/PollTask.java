package chapter7.non_blocking_thread_safe_deque;

import java.util.concurrent.ConcurrentLinkedDeque;

public class PollTask implements Runnable {

    private final ConcurrentLinkedDeque<String> list;

    public PollTask(ConcurrentLinkedDeque<String> list){
        this.list = list;
    }

    @Override
    public void run(){
        for (int i = 0; i < 5_000; i++){
            list.pollFirst();
            list.pollLast();
        }
    }

}
