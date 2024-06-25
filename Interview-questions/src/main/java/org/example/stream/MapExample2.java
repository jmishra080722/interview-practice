package org.example.stream;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapExample2 {
    public static void main(String[] args) throws IOException, URISyntaxException {

        List<Employee> employeeList = getEmployees();


        //get all emp id
        List<Integer> empIds = employeeList.stream()
                .map(emp -> emp.getId())
                .collect(Collectors.toList());
        System.out.println(empIds+"\n=============");


        List<Stream<String>> words =
                Files.lines(Paths.get(ClassLoader.getSystemResource("flatmap.txt").toURI()))     // Stream<String>
                        .map(line -> line.split(" "))             // Stream<String[]>
                        .map(Arrays::stream)                      // Stream<Stream<String>>
                        .distinct()
                        .collect(Collectors.toList());

        System.out.println(words+"\n=============");

       List<String> words1 =
                Files.lines(Paths.get(ClassLoader.getSystemResource("flatmap.txt").toURI()))     // Stream<String>
                        .map(line -> line.split(" "))             // Stream<String[]>
                        .flatMap(Arrays::stream)                      // Stream<Stream<String>>
                        .distinct()
                        .collect(Collectors.toList());

        System.out.println(words1+"\n=============");

        //Find employee with the highest salary, department wise
        Map<String, Employee> maxSalaryByDepartment =
                employeeList.stream()
                                .collect(Collectors.groupingBy(Employee::getDepartment,
                                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)) ,  Optional::get)));
        maxSalaryByDepartment.forEach((department, employee) -> System.out.println(department+" : "+employee));

        System.out.println("=======================");
        //Find number of employee department wise
        Map<String, Long> empCountDeptWise = employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        empCountDeptWise.forEach((department, count) -> System.out.println(department +" : "+count));

        System.out.println("===========================");
        //Find department with the highest number of employee and there count
        Optional<Map.Entry<String, Long>> maxEntry = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue());

                //empCountDeptWise.entrySet().stream().max(Map.Entry.comparingByValue());
        maxEntry.ifPresent(entry -> System.out.println("Department: "+entry.getKey()+" and number of employee: "+entry.getValue()));

    }

    private static List<Employee> getEmployees() {
        Employee e1 = new Employee(1, "Jay", 1000, "Dev");
        Employee e2 = new Employee(2, "Ashish", 1100, "HR");
        Employee e3 = new Employee(3, "Raman", 1050, "Dev");
        Employee e4 = new Employee(4, "Ram", 2000, "IT");
        Employee e5 = new Employee(5, "Aman", 2200, "IT");
        Employee e6 = new Employee(6, "Chandan", 1700, "IT");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
        employeeList.add(e6);
        return employeeList;
    }

    static class Employee{
        private int id;
        private String name;
        private long salary;
        private String department;

        public Employee(int id, String name, long salary, String  department) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getSalary() {
            return salary;
        }

        public void setSalary(long salary) {
            this.salary = salary;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    ", department='" + department + '\'' +
                    '}';
        }
    }
}
