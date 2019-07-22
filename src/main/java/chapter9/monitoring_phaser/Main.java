package chapter9.monitoring_phaser;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {
        Phaser phaser = new Phaser(3);
        for (int i = 0; i < 3; i++){
            Task task = new Task(i + 1, phaser);
            Thread thread = new Thread(task);
            thread.start();
        }

        for (int i = 0; i < 10; i++){
            System.out.println("********************");
            System.out.println("Main: Phaser Log");
            System.out.printf("Main: Phaser: Phase: %d\n", phaser.getPhase());
            System.out.printf("Main: Phaser: Registered Parties: %d\n", phaser.getRegisteredParties());
            System.out.printf("Main: Phaser: Arrived Partied: %d\n", phaser.getArrivedParties());
            System.out.printf("Main: Phaser: Unarrived Parties: %d\n", phaser.getUnarrivedParties());
            System.out.println("********************");
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
