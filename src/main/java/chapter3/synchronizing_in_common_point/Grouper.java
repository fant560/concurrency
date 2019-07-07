package chapter3.synchronizing_in_common_point;

public class Grouper implements Runnable {

    private final Results results;

    public Grouper(Results results){
        this.results = results;
    }

    @Override
    public void run(){
        int finalResult = 0;
        System.out.println("Grouper: Processing results...\n");
        int[] data = results.getData();
        for (int number: data){
            finalResult += number;
        }
        System.out.printf("Grouper: Total result: %d.\n", finalResult);
    }

}
