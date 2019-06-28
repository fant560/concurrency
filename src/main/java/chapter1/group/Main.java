package chapter1.group;

public class Main {

    public static void main(String[] args) {
        int numberOfThreads = 2 * Runtime.getRuntime().availableProcessors();
        // потоки в группе отключаются пачкой
        MyThreadGroup group = new MyThreadGroup("MyThreadGroup");
        Task task = new Task();
        for (int i = 0; i < numberOfThreads; i++){
            Thread t = new Thread(group, task);
            t.start();
        }
        System.out.printf("Number of Threads: %d\n", group.activeCount());
        System.out.print("Information about thread group\n");
        group.list();
        Thread[] threads = new Thread[group.activeCount()];
        group.enumerate(threads);
        for (int i = 0; i < group.activeCount(); i++){
            System.out.printf("Thread %s : %s \n", threads[i].getName(), threads[i].getState());
        }
    }

}
