package chapter1;

import java.util.Date;

public class FinalizingMain {

    public static void main(String[] args) {
        DataSourcesLoader loader = new DataSourcesLoader();
        Thread thread1 = new Thread(loader, "DataSourceThread");
        NetworkConnectionLoader networkConnectionLoader = new NetworkConnectionLoader();
        Thread thread2 = new Thread(networkConnectionLoader, "NetworkConnectionThread");

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // ждет пока завершатся присоединенные потоки
        System.out.printf("Main: Configuration has been loaded: %s\n", new Date());

    }

}
