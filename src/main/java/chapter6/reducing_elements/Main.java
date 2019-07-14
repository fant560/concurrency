package chapter6.reducing_elements;

import java.util.List;
import java.util.stream.DoubleStream;

public class Main {

    public static void main(String[] args) {
        List<Double> numbers = DoubleGenerator.generateDoubleList(10000, 1000);
        DoubleStream doubleStream = DoubleGenerator.generateStreamFromList(numbers);
        long numberOfElements = doubleStream.parallel().count();
        System.out.printf("The list of numbers has %d elements.\n", numberOfElements);
        doubleStream = DoubleGenerator.generateStreamFromList(numbers);
        double sum = doubleStream.parallel().sum();
        System.out.printf("It's numbers sum %f\n", sum);
        // 253 страница
    }

}
