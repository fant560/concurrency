package chapter10.fork_join_exceptions;

public class Handler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e){
        System.out.printf("Handler: Thread %s has thrown an Exception.\n", t.getName());
        System.out.printf("%s\n", e);
        System.exit(-1);
    }

}
