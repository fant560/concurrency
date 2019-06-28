package chapter1.shared;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        // так не стоит
      /*  UnsafeTask task = new UnsafeTask();
        for (int i = 0; i < 10; i++){
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }*/
        SafeTask task = new SafeTask();
        for (int i = 0; i < 10; i++){
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        // InheritableThreadLocal - для расшаривания данных между потоками созданными внутри одного потока

    }

}
