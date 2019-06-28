package chapter1.exception;

/**
 * Для обработки непроверяемых исключений в потоке
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread thread, Throwable e) {
        System.out.println("An Exception has captured");
        System.out.printf("Thread: %s: \n", thread.getId());
        System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
        System.out.print("Stack trace: \n");
        e.printStackTrace(System.out);
        System.out.printf("Thread status: %s\n", String.valueOf(thread.getState()));

    }
}
