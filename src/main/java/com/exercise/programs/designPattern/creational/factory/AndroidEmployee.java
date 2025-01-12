package com.exercise.programs.designPattern.creational.factory;

public class AndroidEmployee implements Employee{
    @Override
    public int salary() {
        System.out.println("Getting Android Employee Salary");
        return 1688300;
    }
}
