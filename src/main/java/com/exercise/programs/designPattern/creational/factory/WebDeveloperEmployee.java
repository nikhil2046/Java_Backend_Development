package com.exercise.programs.designPattern.creational.factory;

public class WebDeveloperEmployee implements Employee{
    @Override
    public int salary() {
        System.out.println("Getting Web Developer Employee Salary");
        return 140000;
    }
}
