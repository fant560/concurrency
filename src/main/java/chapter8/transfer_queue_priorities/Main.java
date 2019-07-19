package chapter8.transfer_queue_priorities;

import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) throws Exception {
        MyPriorityTransferQueue<Event> buffer = new MyPriorityTransferQueue<>();

        Producer producer = new Producer(buffer);
        Thread[] producerThreads = new Thread[10];
        for (int i = 0; i < producerThreads.length; i++){
            producerThreads[i] = new Thread(producer);
            producerThreads[i].start();
        }
        Consumer consumer = new Consumer(buffer);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

        System.out.printf("Main: Buffer: Consumer count: %d\n", buffer.getWaitingConsumerCount());
        Event myEvent = new Event("Core Event", 0);
        buffer.transfer(myEvent);
        System.out.println("Main: My event has been transferred");
        for (Thread producerThread : producerThreads) {
                producerThread.join();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.printf("Main: Buffer: Consumer count: %d\n", buffer.getWaitingConsumerCount());
        myEvent = new Event("Core Event 2", 0);
        buffer.transfer(myEvent);

        consumerThread.join();

        System.out.println("Main: End of the program");

    }

}
