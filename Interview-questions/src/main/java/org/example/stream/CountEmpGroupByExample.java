package org.example.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountEmpGroupByExample {
    public static void main(String[] args) {

        Employee e1 = new Employee("Jay", 29, "Araria", 20000);
        Employee e2 = new Employee("Ashish", 29, "Araria", 20000);
        Employee e3 = new Employee("Ram", 29, "Patna", 20000);
        Employee e4 = new Employee("Kumar", 29, "Hyd", 20000);
        Employee e5 = new Employee("Aman", 29, "Patna", 20000);
        Employee e6 = new Employee("Raman", 29, "Hyd", 20000);
        Employee e7 = new Employee("Rakesh", 29, "Chennai", 20000);
        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7);

        //Find employees group by city
        Map<String, List<Employee>> employeeGroup1 =  employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.getCity()));
        System.out.println(employeeGroup1);

        System.out.println("=================");
        //find employee count group by city
        Map<String, Long> employeeGroup = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()));
        System.out.println(employeeGroup);

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
