package com.exercise.programs.designPattern.creational.factory;

public class EmployeeFactory {
    static Employee getEmployee(String emp) {
        if (emp.equalsIgnoreCase("Android")) {
            return new AndroidEmployee();
        }
        if (emp.equalsIgnoreCase("Web")) {
            return new WebDeveloperEmployee();
        }
        return null;
    }
}
