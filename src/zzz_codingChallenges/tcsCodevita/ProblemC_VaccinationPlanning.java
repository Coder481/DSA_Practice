package zzz_codingChallenges.tcsCodevita;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProblemC_VaccinationPlanning {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        List<Center> centerList = new ArrayList<>();

        // Taking Input of centers
        for(int i = 0; i<M; i++){
            Scanner sc1 = new Scanner(System.in);
            String[] latLangs = sc1.nextLine().split(" ");
            double lat = Double.parseDouble(latLangs[0]);
            double lang = Double.parseDouble(latLangs[1]);
            centerList.add(new Center(lat, lang));
        }

        int N = sc.nextInt();
        for(int i = 0; i<N; i++){
            Scanner sc1 = new Scanner(System.in);
            String[] personCred = sc1.nextLine().split(" ");
            String name = personCred[0];
            int age = Integer.parseInt(personCred[1]);
            String category = personCred[2];
            double lat = Double.parseDouble(personCred[3]);
            double lang = Double.parseDouble(personCred[4]);

            // Getting the index of the nearest center to this person from centerList
            int allottedCenterIndex = 0;
            double minDis = getDistance(lat, lang, centerList.get(allottedCenterIndex).lat, centerList.get(allottedCenterIndex).lang);
            for(int j=1; j<M; j++){
                double dis = getDistance(lat, lang, centerList.get(j).lat,centerList.get(j).lang);
                if(dis < minDis){
                    allottedCenterIndex = j;
                }
            }

            Person person = new Person(name, age, category, lat, lang);
            centerList.get(allottedCenterIndex).personsAllotted.add(person);
        }


        // Now we have the list of centers with allotted persons
        // And we need to sort every center allottedPerson list
        Comparator<Person> comparator = Comparator.comparing(Person::getAge).reversed()
                .thenComparing(Person::getCategory)
                .thenComparing(Person::getName);
        for(Center center : centerList){
            if(center.personsAllotted.isEmpty())
                System.out.print("Empty Centre");
            else{
                center.personsAllotted.sort(comparator);
                center.personsAllotted.forEach(person -> System.out.print(person.getName() + " "));
            }
            System.out.println();
        }
    }


    private static double getDistance(double x1, double y1, double x2, double y2){
        return Math.sqrt( Math.pow((x2-x1) , 2) + Math.pow((y2-y1) , 2));
    }

    static class Center{
        double lat;
        double lang;
        List<Person> personsAllotted = new ArrayList<>();
        public Center(double lat, double lang) {
            this.lat = lat;
            this.lang = lang;
        }
    }

    static class Person{
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
}


