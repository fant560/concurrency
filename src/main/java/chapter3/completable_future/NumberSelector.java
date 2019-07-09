package chapter3.completable_future;

import java.util.List;
import java.util.function.Function;

public class NumberSelector implements Function<List<Long>, Long> {

    @Override
    public Long apply(List<Long> list) {
        System.out.printf("%s: Step3: Start\n", Thread.currentThread().getName());
        long max = list.stream().max(Long::compare).get();
        long min = list.stream().min(Long::compare).get();
        long result = (max + min) / 2;
        System.out.printf("%s: Step3: Result - %d", Thread.currentThread().getName(), result);
        return result;
    }

}
