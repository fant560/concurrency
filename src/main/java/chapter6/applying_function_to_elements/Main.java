package chapter6.applying_function_to_elements;

import chapter6.util.Person;
import chapter6.util.PersonGenerator;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> persons = PersonGenerator.generatePersonList(10);
        persons.parallelStream().forEach(p -> System.out.printf("%s, %s\n", p.getLastName(), p.getFirstName()));

        List<Double> doubles = DoubleGenerator.generateDoubleList(10, 100);
        System.out.print("Parallel forEachOrdered() with numbers\n");
        doubles.parallelStream().sorted().forEachOrdered(n -> System.out.printf("%f\n", n));

        System.out.println("Parallel forEach() after sorted() with numbers");
        doubles.parallelStream().sorted().forEach(n -> System.out.printf("%f\n", n));

        persons.parallelStream().sorted().forEachOrdered(p -> System.out.printf("%s, %s\n", p.getLastName(), p.getFirstName()));

        doubles.parallelStream()
                .peek(d -> System.out.printf("Step 1: Number: %f\n", d))
                .peek(d -> System.out.printf("Step 2: Number: %f\n", d))
                .forEach(d -> System.out.printf("Final Step: Number: %f\n", d));

    }

}
