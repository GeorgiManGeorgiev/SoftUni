package C_JavaAdvanced.JavaAdv.DefiningClasses.CompanyRosterExersice;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,Department> departments = new HashMap<>();


        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];


            Employee employee;
            switch (tokens.length) {

                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    try {
                        int age = Integer.parseInt(tokens[4]);
                        employee = new Employee(name, salary, position, department, age);
                    } catch (NumberFormatException e) {
                        String email = tokens[4];
                        employee = new Employee(name, salary, position, department, email);
                    }
                    break;

                default:
                    String email = tokens[4];
                    int age = Integer.parseInt(tokens[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
            }

            departments.putIfAbsent(department,new Department(department));
            departments.get(department).getEmployees().add(employee);
        }
        Department maxDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(f -> f.getValue().getAvgSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: "+ maxDepartment.getName());
        maxDepartment.getEmployees()
                .stream()
                .sorted((f,s)->Double.compare(s.getSalary(),f.getSalary()))
                .forEach(System.out::println);



    }


}
