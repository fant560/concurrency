package chapter8.custom_thread_factory;

import java.util.Date;

public class MyThread extends Thread {

    private final Date creationDate;
    private Date startDate;
    private Date finishDate;

    public MyThread(Runnable target, String name){
        super(target, name);
        creationDate = new Date();
    }

    @Override
    public void run(){
        setStartDate();
        super.run();
        setFinishDate();
    }

    public synchronized void setStartDate(){
        startDate = new Date();
    }

    public synchronized  void setFinishDate(){
        finishDate = new Date();
    }

    public synchronized long getExecutionTime(){
        return finishDate.getTime() - startDate.getTime();
    }

    @Override
    public synchronized String toString(){
        return getName() +
                ": Creation Date: " +
                creationDate +
                " : Running time: " +
                getExecutionTime() +
                " Milliseconds.";
    }

}
