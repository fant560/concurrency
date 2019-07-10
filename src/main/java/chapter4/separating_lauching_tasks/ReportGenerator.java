package chapter4.separating_lauching_tasks;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ReportGenerator implements Callable<String> {

    private final String sender;
    private final String title;

    public ReportGenerator(String sender, String title){
        this.sender = sender;
        this.title = title;
    }
    @Override
    public String call() throws Exception {
        try {
            long duration = (long)(Math.random() * 10);
            System.out.printf("%s_%s: Report Generator: Generating a report during %d seconds\n",
                    sender, title, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return sender + ": " + title;
    }
}
