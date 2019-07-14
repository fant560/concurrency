package chapter6.streams_from_different_sources;

import java.util.*;

public class PersonGenerator {

    public static List<Person> generatePersonList(int size) {
        List<Person> result = new ArrayList<>();
        String[] firstNames = {"Mary", "Patricia", "Linda", "Barbara", "Elizabeth", "James", "John", "Robert", "Michael", "William"};
        String[] lastNames = {"Smith", "Jones", "Taylor", "Williams", "Brown", "Davies", "Evans", "Wilson", "Thomas", "Roberts"};

        Random randomGenerator = new Random();
        for (int i = 0; i < size; i++){
            Person person = new Person();
            person.setId(i);
            person.setFirstName(firstNames[randomGenerator.nextInt(10)]);
            person.setLastName(lastNames[randomGenerator.nextInt(10)]);
            person.setSalary(randomGenerator.nextInt(100_000));
            person.setCoefficient(randomGenerator.nextDouble() * 10);
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, -randomGenerator.nextInt(30));
            Date birthDate = calendar.getTime();
            person.setBirthDate(birthDate);
            result.add(person);
        }
        return result;
    }


}
