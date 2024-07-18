package org.example.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.example.stream.Employee.getEmpList;

public class MapFromList {

    public static void main(String[] args) {

        System.out.println("Hi....");
        List<Employee> empList = getEmpList();

        //Task1 -> Trasnform list to Map
        Map<Integer, String> empMap = empList.stream()
                .collect(Collectors.toMap(Employee::getEmpId,
                                                            Employee::getFirstName));
        System.out.println(empMap);
        System.out.println("====================");
        //Task 2: Get employee with 2nd highest salary
        Optional<Employee> empWithSecondHighestSalary = empList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();
        empWithSecondHighestSalary.ifPresent(employee -> System.out.println("Employee with 2nd highest salary: " + employee));


    }



}
