package org.example.stream;

import java.util.*;
import java.util.stream.Collectors;

public class CountEmpGroupByExample {
    public static void main(String[] args) {

        List<Employee> employees = getEmployees();

        //Find employees group by city
        Map<String, List<Employee>> employeeGroup1 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity));
        System.out.println(employeeGroup1);
        System.out.println("=================");

        //find employee count group by city
        Map<String, Long> employeeGroup = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()));
        System.out.println(employeeGroup);
        System.out.println("======================");
        //Add the salary city wise
        Map<String, Long> totalSalaryCityWise = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity, Collectors.summingLong(Employee::getSalary))) ;
        System.out.println(totalSalaryCityWise);
        System.out.println("=======================");
        //Add salary city wise and display in sorted order
        List<Map.Entry<String, Long>> totalSalaryCityWiseSorted = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity, Collectors.summingLong(Employee::getSalary)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        System.out.println(totalSalaryCityWiseSorted);
    }

    private static List<Employee> getEmployees() {
        Employee e1 = new Employee("Jay", 29, "Araria", 20000);
        Employee e2 = new Employee("Ashish", 29, "Araria", 15000);
        Employee e3 = new Employee("Ram", 29, "Patna", 30000);
        Employee e4 = new Employee("Kumar", 29, "Hyd", 40000);
        Employee e5 = new Employee("Aman", 29, "Patna", 25000);
        Employee e6 = new Employee("Raman", 29, "Hyd", 46000);
        Employee e7 = new Employee("Rakesh", 29, "Chennai", 50000);
        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7);
        return employees;
    }

    static class Employee{
        String name;
        int age;
        String city;
        long salary;

        public Employee(String name, int age, String city, long salary) {
            this.name = name;
            this.age = age;
            this.city = city;
            this.salary = salary;
        }

        public String getCity() {
            return city;
        }

        public long getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", city='" + city + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}
