package chapter10.fork_join_exceptions;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

public class ExceptionWorker extends ForkJoinWorkerThread {

    protected ExceptionWorker(ForkJoinPool pool){
        super(pool);
    }

    @Override
    protected void onStart(){
        super.onStart();
        throw new RuntimeException("Exception from worker thread");
    }


}
