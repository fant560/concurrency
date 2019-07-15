package chapter6.streams_from_different_sources;

import chapter6.util.Person;
import chapter6.util.PersonGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println("From a Collection:\n");
        List<Person> persons = PersonGenerator.generatePersonList(10_000);
        Stream<Person> personStream = persons.parallelStream();
        System.out.printf("Number of persons: %d\n", personStream.count());
        System.out.println("From a Supplier: ");
        Supplier<String> supplier = new MySupplier();
        Stream<String> generatorStream = Stream.generate(supplier);
        generatorStream.parallel().limit(10).forEach(s -> System.out.printf("%s\n", s));

        System.out.println("From a predefined set of elements:");
        Stream<String> elementsStream = Stream.of("Peter", "John", "Mary");
        elementsStream.parallel().forEach(element -> System.out.printf("%s\n", element));

        System.out.println("From a File:");
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            Stream<String> fileLines = br.lines();
            System.out.printf("Number of lines in the file: %d\n\n", fileLines.parallel().count());
            System.out.println("********************");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("From a Directory:");
        try {
            // Найти все файлы внутри директории
            // Files.find(Path start, int maxDepths, BiPredicate<Path,BasicFileVisitOption> matcher, FileFisitOption... options)
            // Files.walk - список путей внутри директории включая поддиректории
            // стрим из списка путей внутри директории
            Stream<Path> directoryContent = Files.list(Paths.get(System.getProperty("user.home")));
            System.out.printf("Number of elements (files and folders): %d\n\n", directoryContent.parallel().count());
            directoryContent.close();
            System.out.println("*********************************");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("From an Array:");
        String[] array = {"1", "2", "3", "4", "5"};
        Stream<String> streamFromArray = Arrays.stream(array);
        streamFromArray.parallel().forEach(s -> System.out.printf("%s : ", s));

        Random random = new Random();
        DoubleStream doubleStream = random.doubles(10);
        double doubleStreamAverage = doubleStream.parallel().peek(d -> System.out.printf("%f: ", d)).average().getAsDouble();

        System.out.println("Concatenating streams: ");
        Stream<String> stream1 = Stream.of("1", "2", "3", "4");
        Stream<String> stream2 = Stream.of("5", "6", "7", "8");
        Stream<String> finalStream = Stream.concat(stream1, stream2);
        finalStream.parallel().forEach(s -> System.out.printf("%s : ", s));

    }
}
