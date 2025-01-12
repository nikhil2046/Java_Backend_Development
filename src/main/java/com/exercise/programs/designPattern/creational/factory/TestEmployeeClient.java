package com.exercise.programs.designPattern.creational.factory;

public class TestEmployeeClient {
    public static void main(String[] args) {
        Employee employee = EmployeeFactory.getEmployee("web");
        System.out.println(employee.salary());
    }
}
