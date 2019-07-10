package chapter4.separating_lauching_tasks;

import java.util.concurrent.CompletionService;

public class ReportRequest implements Runnable {

    private final String name;
    private final CompletionService<String> service;

    public ReportRequest(String name, CompletionService<String> service){
        this.name = name;
        this.service = service;
    }

    @Override
    public void run(){
        ReportGenerator generator = new ReportGenerator(name, "report");
        service.submit(generator);
    }



}
