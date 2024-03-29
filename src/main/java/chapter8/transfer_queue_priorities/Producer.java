package chapter8.transfer_queue_priorities;

public class Producer implements Runnable  {

    private final MyPriorityTransferQueue<Event> buffer;

    public Producer(MyPriorityTransferQueue<Event> buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            Event event = new Event(Thread.currentThread().getName(), i);
            buffer.put(event);
        }
    }
}
