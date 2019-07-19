package chapter8.custom_thread_factory;

public class Main {

    public static void main(String[] args) throws Exception {
        MyThreadFactory myThread = new MyThreadFactory("MyThreadFactory");
        MyTask task = new MyTask();
        Thread thread = myThread.newThread(task);
        thread.start();
        thread.join();

        System.out.println("Main: Thread information.");
        System.out.printf("%s\n", thread);
        System.out.println("Main: End of the example");
    }

}
