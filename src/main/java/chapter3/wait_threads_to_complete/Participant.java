package chapter3.wait_threads_to_complete;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {
    private VideoConference conference;
    private String name;

    public Participant(VideoConference conference, String name){
        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run(){
        long duration = (long)(Math.random() * 10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        conference.arrive(name);
    }

}
