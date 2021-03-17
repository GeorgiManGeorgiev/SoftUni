package C_JavaAdvanced.JavaAdv.FunctionalProgramming.LAB;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class five {

    private static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(", ");
            people.add(new Person(tokens[0], Integer.parseInt(tokens[1])));
        }

        Map<String, Predicate<Person>> predicateMap = new HashMap<>();
        String ageCondition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        predicateMap.put("younger", person -> person.age <= age);
        predicateMap.put("older", person -> person.age >= age);


        Map<String, Consumer<Person>> consumerMap = new HashMap<>();
        String format = scanner.nextLine();

        consumerMap.put("name", person -> System.out.println(person.name));
        consumerMap.put("age", person -> System.out.println(person.age));
        consumerMap.put("name age", person -> System.out.println(person.name + " - " + person.age));
        people.stream()
                .filter(predicateMap.get(ageCondition))
                .forEach(consumerMap.get(format));

    }
}
