package z_labWork.sem6.competitiveCoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lab_9_Knapsack {

    public static void main(String[] args) {

        String[] names = {"Atul","Sunil","Rajni","Kunal"};
        int[] prices = {24,24,23,24};
        String[] category = {"A","B","A","A"};
        int[] weights = {1,0,1,1};
        int capacity = 150;

        List<Vegetable> vegetables = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            vegetables.add(new Vegetable(
                    names[i],
                    prices[i],
                    weights[i])
            );
        }

        Comparator<Vegetable> comparatorWithPrice = Comparator.comparing(Vegetable::getPrice)
                .thenComparing(Vegetable::getWeight)
                .thenComparing(Vegetable::getName);
        vegetables.sort(comparatorWithPrice);

//        printVegetables(vegetables);




        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            persons.add(new Person(
                    names[i],
                    prices[i],
                    category[i],0,0)
            );
        }
        Comparator<Person> comparator = Comparator.comparing(Person::getAge).reversed()
                .thenComparing(Person::getCategory)
                .thenComparing(Person::getName);
        persons.sort(comparator);
        persons.forEach(person -> System.out.println(person.name +  " "));

    }

    private static void printVegetables(List<Vegetable> vegetables) {
        for(Vegetable veg : vegetables)
            System.out.println(veg.name + ": " + veg.price + "/kg, " + veg.weight + "kg");
    }

}

class Person{
    public String name;
    public int age;
    String category;
    double lat;
    double lang;

    public Person(String name, int age, String category, double lat, double lang) {
        this.name = name;
        this.age = age;
        this.category = category;
        this.lat = lat;
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCategory() {
        return category;
    }
}
class Vegetable{
    String name;
    int price;
    int weight;

    public Vegetable(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }
}
