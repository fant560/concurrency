package chapter1.factory;

import java.util.concurrent.ThreadFactory;

public class Main {
    /**
     * Можно так, если не хочется класс писать.
     */
    public static final ThreadFactory tf = t -> {
        System.out.println("Before creation");
        return new Thread(t);
    };

    public static void main(String[] args) {
        MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
        Task task = new Task();
        Thread thread;
        System.out.print("Starting the Threads\n");
        for (int i = 0; i < 10; i++) {
            thread = factory.newThread(task);
            thread.start();
        }
        System.out.println("Factory stats");
        System.out.printf("%s\n", factory.getStats());
    }

}
