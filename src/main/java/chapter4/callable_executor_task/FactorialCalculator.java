package chapter4.callable_executor_task;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCalculator implements Callable<Integer> {

    private final Integer number;

    public FactorialCalculator(Integer number){
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;
        if ((number == 0) || (number == 1))
            return 1;
        for (int i = 2; i <= number; i++){
            result *= i;
            TimeUnit.MILLISECONDS.sleep(20);
        }
        System.out.printf("%s: %d\n", Thread.currentThread().getName(), result);
        return result;
    }

}
