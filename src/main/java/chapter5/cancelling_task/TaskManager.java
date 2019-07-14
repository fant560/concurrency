package chapter5.cancelling_task;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ForkJoinTask;

public class TaskManager {

    private final ConcurrentLinkedDeque<SearchNumberTask> tasks;

    public TaskManager() {
        tasks = new ConcurrentLinkedDeque<>();
    }

    public void addTask(ForkJoinTask<Integer> task) {
        tasks.add((SearchNumberTask) task);
    }

    public void cancelTasks(SearchNumberTask cancelTask) {
        for (SearchNumberTask task : tasks) {
            if (task != cancelTask) {
                task.cancel(true);
                task.logCancelMessage();
            }
        }
    }

}
