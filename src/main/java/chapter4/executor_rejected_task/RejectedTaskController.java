package chapter4.executor_rejected_task;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedTaskController implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        System.out.printf("RejectedTaskController: The task %s has been rejected\n",runnable.toString());
        System.out.printf("RejectedTaskController: %s\n", threadPoolExecutor.toString());
        System.out.printf("RejectedTaskController: Terminating: %s\n", threadPoolExecutor.isTerminating());
        System.out.printf("RejectedTaskController: Terminated: %s\n", threadPoolExecutor.isTerminated());
    }
}
