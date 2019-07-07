package chapter3.wait_threads_to_complete;

import java.util.concurrent.CountDownLatch;

public class VideoConference implements Runnable {

    private final CountDownLatch controller;

    public VideoConference(int number){
        // проинициализировать объект. Проинициализировать повторно нельзя на том же объекте.
        controller = new CountDownLatch(number);
    }

    public void arrive(String name) {
        System.out.printf("%s has arrived.", name);
        // уменьшение количества потоков которым осталось ждать
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n", controller.getCount());
    }

    @Override
    public void run(){
        System.out.printf("VideoConference: Initialization: %d participants.\n", controller.getCount());
        try {
            // ждет завершения всех потоков и потом выполняет операции
            // есть await(long time, TimeUnit unit)
            controller.await();
            System.out.print("VideoConference: All the participatns have come.\n");
            System.out.println("VideoConference: Let's start...\n");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
