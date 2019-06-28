package chapter1.exception;

public class Task implements Runnable {
    @Override
    public void run() {
        int number = Integer.parseInt("TTT");
    }
}
