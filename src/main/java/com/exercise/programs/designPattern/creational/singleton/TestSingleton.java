package com.exercise.programs.designPattern.creational.singleton;

public class TestSingleton {
    public static void main(String[] args) {
        Laptop laptop1 = Laptop.getLaptopInstance();
        System.out.println(laptop1.hashCode());
        Laptop laptop2 = Laptop.getLaptopInstance();
        System.out.println(laptop2.hashCode());

        try {
            Laptop laptop3 = (Laptop) laptop1.clone();
            System.out.println(laptop3.hashCode());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }
}
