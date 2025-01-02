package com.exercise.programs.java_8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Interview_01 {
   /* public static void main(String[] args) {
        Map<String, Map<String, Long>> out = getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(Employee::getCity,
                        Collectors.groupingBy(Employee::getGender, Collectors.counting())));



        out.forEach((city, genderMap) -> {
            genderMap.forEach((gender, count) -> System.out.println(city + ", " + gender + ", Count=" + count));
        });

        System.out.println(getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.toList(), list ->
                        list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst()
                ))));
    }


    static List<Employee> getEmployeeList() {
        return
                List.of(
                        new Employee("Arpit", 23L, 352266.0, "IT", "Delhi", "Male"),
                        new Employee("Nilesh", 33L, 426636.6, "IT", "Pune", "Male"),
                        new Employee("Simran", 25L, 366466.6, "Sales", "Pune", "Female"),
                        new Employee("Prachi", 29L, 577463.4, "Sales", "Delhi", "Female"),
                        new Employee("James", 34L, 2321442.5, "Sales", "Delhi", "Male")
                );
    }*/
}


