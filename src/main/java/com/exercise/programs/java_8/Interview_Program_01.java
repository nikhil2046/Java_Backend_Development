package com.exercise.programs.java_8;

import com.exercise.programs.datahub.EmployeeDataHub;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Interview_Program_01 {
    public static void main(String[] args) {
        List<Employee> employeeList = EmployeeDataHub.getEmployees();
        //sort employee based on salary

        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .toList()
                .forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------");

       Map<String,Map<String,List<Employee>>> sortByCityThenDepartment =  employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getCity,Collectors.groupingBy(Employee::getDepartment)));
        sortByCityThenDepartment.forEach((k,c)->{
            System.out.println(k+" : ");
            c.forEach((d,v)->{
                System.out.println(d+" : "+v);
            });
        });
    }
}
