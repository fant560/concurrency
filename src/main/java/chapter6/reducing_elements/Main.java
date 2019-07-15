package chapter6.reducing_elements;

import chapter6.util.Person;
import chapter6.util.PersonGenerator;

import java.util.List;
import java.util.Optional;
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

        doubleStream = DoubleGenerator.generateStreamFromList(numbers);
        double average = doubleStream.parallel().average().getAsDouble();
        System.out.printf("It's numbers have an average value of %f.\n", average);

        doubleStream = DoubleGenerator.generateStreamFromList(numbers);
        double max = doubleStream.parallel().max().getAsDouble();
        System.out.printf("The maximum value in the list is %f.\n", max);

        doubleStream = DoubleGenerator.generateStreamFromList(numbers);
        double min = doubleStream.parallel().min().getAsDouble();
        System.out.printf("The minimum value in the list is %f.\n", min);

        List<Point> points = PointGenerator.generatePointList(10000);
        Optional<Point> point = points.parallelStream().reduce((p1, p2) -> {
            Point p = new Point();
            p.setX(p1.getX() + p2.getX());
            p.setY(p1.getY() + p2.getY());
            return p;
        });
        System.out.println(point.get().getX() + ":" + point.get().getY());

        System.out.println("Reduce, second version");
        List<Person> persons = PersonGenerator.generatePersonList(10000);
        // другая версия reduce
        long totalSalary = persons.parallelStream().map(p -> p.getSalary()).reduce(0, (s1, s2) -> s1 + s2);
        System.out.printf("Total salary: %d\n", totalSalary);
        // третья версия reduce
        // функция - тип накопителя, функция, оператор для накопителя
        Integer value = 0;
        value = persons.parallelStream().reduce(value, (n, p) -> {
            if (p.getSalary() > 50000)
                return n + 1;
            else return n;
        }, (n1, n2) -> n1 + n2);
        System.out.printf("The number of people with a salary bigger than 50,000 is %d\n", value);
    }

}
