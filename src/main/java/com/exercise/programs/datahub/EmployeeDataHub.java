package com.exercise.programs.datahub;

import com.exercise.programs.java_8.Employee;

import java.util.Arrays;
import java.util.List;

public class EmployeeDataHub {
    public static List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee("Alice", 30, 70000, "HR", "Pune", "Female"),
                new Employee("Bob", 35, 80000, "HR", "Mumbai", "Male"),
                new Employee("Charlie", 28, 60000, "HR", "Pune", "Male"),
                new Employee("Diana", 32, 120000, "IT", "Bangalore", "Female"),
                new Employee("Eve", 29, 90000, "IT", "Hyderabad", "Female"),
                new Employee("Frank", 40, 100000, "IT", "Chennai", "Male"),
                new Employee("Grace", 27, 75000, "Finance", "Pune", "Female"),
                new Employee("Hannah", 38, 85000, "Finance", "Delhi", "Female"),
                new Employee("Ian", 45, 65000, "Finance", "Delhi", "Male"),
                new Employee("Jack", 34, 95000, "IT", "Bangalore", "Male"),
                new Employee("Kathy", 33, 85000, "HR", "Mumbai", "Female"),
                new Employee("Leo", 29, 70000, "Finance", "Chennai", "Male"));
    }
}
