package chapter2.synch_conditional;

public class Producer implements Runnable {

    private final EventStorage storage;

    public Producer(EventStorage storage){
        this.storage = storage;
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++)
            storage.set();
    }





}
