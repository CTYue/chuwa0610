package PracticeStreamAPI;

import PracticeOptional.Item;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiTest{
    public static void main(String[] args) {
        List<Person> classmates = new ArrayList<>();
        classmates.add(new Person("Alice", "123 Main St", 5));
        classmates.add(new Person("Bob", "456 Maple Ave", 10));
        classmates.add(new Person("Charlie", "789 Oak Dr", 8));
        classmates.add(new Person("David", "321 Elm St", 12));
        classmates.add(new Person("Eva", "654 Pine Rd", 6));
        classmates.add(new Person("Frank", "987 Cedar Ln", 15));
        classmates.add(new Person("Grace", "741 Birch Blvd", 7));
        classmates.add(new Person("Hannah", "852 Walnut Way", 9));
        classmates.add(new Person("Ivy", "963 Maple St", 11));
        classmates.add(new Person("Jack", "369 Oak Ln", 14));

        double Alicesoubs = classmates.stream()
                .filter(item->item.getName().equals("Alice"))
                .mapToDouble(Person::getSubs)
                .sum();
        System.out.println("Alice has subs of : "  + Alicesoubs);

        int totalSum = classmates.stream()
                .mapToInt(Person::getSubs)
                .sum();
        System.out.println("Total sum subs : "  + totalSum);

        OptionalInt  maxSubs = classmates.stream()
                .mapToInt(Person::getSubs)
                .reduce(Integer::max);
        System.out.println("max subs : "  + maxSubs.orElse(-1));

        List<String> all_name = classmates.stream()
                .map(Person::getName)
                .toList();
        all_name.forEach((item) -> System.out.println("NAME:"+item));

        OptionalDouble averageSubs = classmates.stream()
                .mapToDouble(Person::getSubs)
                .average();
        System.out.println("Average is : " + averageSubs.orElse(-1.00));

        List<String> belowTen = classmates.stream()
                .filter(item -> (item.getSubs() > 10))
                .map(Person::getName)
                .toList();
        belowTen.forEach((item) -> System.out.println("NAME:"+item) );
    }




}

class Person{
    private String name;
    private String address;
    private int subs;



    Person(String name, String address,int subs){
        this.name = name;
        this.address=address;
        this.subs= subs;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSubs() {
        return subs;
    }

    public void setSubs(int subs) {
        this.subs = subs;
    }


}