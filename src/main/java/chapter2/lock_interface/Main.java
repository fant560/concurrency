package chapter2.lock_interface;

public class Main {

    public static void main(String[] args) {
        System.out.println("Running example with fair-mode = false");
        testPrintQueue(false);
        System.out.println("Running example with fair-mode = true");
        testPrintQueue(true);

    }

    private static void testPrintQueue(Boolean fairMode) {
        PrintQueue printQueue = new PrintQueue(fairMode);
        Thread[] thread = new Thread[10];
        for (int i = 0; i < 10; i++){
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }
        for (int i = 0; i < 10; i++)
            thread[i].start();
        for (int i = 0; i < 10; i++){
            try {
                thread[i].join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }


}
