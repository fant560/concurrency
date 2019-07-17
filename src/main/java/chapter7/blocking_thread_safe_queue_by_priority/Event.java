package chapter7.blocking_thread_safe_queue_by_priority;

public class Event implements Comparable<Event> {

    private final int thread;
    private final int priority;

    public Event(int thread, int priority){
        this.thread = thread;
        this.priority = priority;
    }

    public int getThread() {
        return thread;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Event e){
        return Integer.compare(e.getPriority(), this.priority);
    }

}
