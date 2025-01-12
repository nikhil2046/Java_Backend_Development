package com.exercise.programs.designPattern.creational.singleton;

public class Laptop implements Cloneable{
    private static Laptop INSTANCE = null;

    private Laptop(){

    }
    public static Laptop getLaptopInstance() {
        if (INSTANCE == null) {
             INSTANCE = new Laptop();
        }
        return INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("You are notable to make clone of this object...!");
    }
}
