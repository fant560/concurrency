package chapter2.synch_conditional;

public class Main {

    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Producer producer = new Producer(storage);
        Thread producerThread = new Thread(producer);

        Consumer consumer = new Consumer(storage);
        Thread consumerThread = new Thread(consumer);

        consumerThread.start();
        producerThread.start();
    }

}
