package com.exercise.programs.inheritance_programs;
//
 //Q1. If Class B extends Class A then what will be the order of execution of static initializers,
// instance initializers, and constructors ?
public class Interview_01 {
    public static void main(String[] args) {
        B b = new B();
    }
}


 class A {
    static {
        System.out.println("This is static block on Class A");
    }

    //instance initilizer
    {
        System.out.println("this is instance initializer of Class A");
    }

    A() {
        System.out.println("Constructor of Class A");
    }
}

class B extends A{
    static {
        System.out.println("This is static block on Class B");
    }

    //instance initializer
    {
        System.out.println("this is instance initializer of Class B");
    }

    B() {
        System.out.println("Constructor of Class B");
    }
}