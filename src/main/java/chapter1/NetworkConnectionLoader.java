package chapter1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Beginning network sources loading: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.printf("Network sources loading has finished: %s\n", new Date());

    }
}
