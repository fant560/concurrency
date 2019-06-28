package chapter1.exception;

public class Main {

    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
        // для всех потоков внутри jvm
        // Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
        // сначала поиск в объекте треда
        // потом поиск в ThreadGroup
        // потом DefaultUncaughtExceptionHandler
        // если JVM не нашла ничего, то тогда жвм просто напечатает трейс
    }

}
