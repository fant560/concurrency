package chapter6.util;

import java.util.Comparator;
import java.util.Date;

public class Person implements Comparable<Person> {

    private static Comparator<Person> comparator = Comparator.comparing(Person::getLastName)
            .thenComparing(Person::getLastName);

    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int salary;
    private double coefficient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public int compareTo(Person otherPerson){
       return comparator.compare(this, otherPerson);
    }

    @Override
    public String toString(){
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object object){
        return this.compareTo((Person)object) == 0;
    }

    @Override
    public int hashCode(){
        String sequence = this.getLastName() + this.getFirstName();
        return sequence.hashCode();
    }
}
