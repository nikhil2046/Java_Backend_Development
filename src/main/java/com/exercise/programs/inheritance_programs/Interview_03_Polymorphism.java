package com.exercise.programs.inheritance_programs;

public class Interview_03_Polymorphism {
    public static void main(String[] args) {
        Users customer = new Customer("nikhil","nik123");
        Users admin = new Admin("admin","admin123");

        customer.postLogin();
        admin.postLogin();
    }
}

abstract class Users {
    protected String username;
    private String password;

    Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    abstract void postLogin();
}


class Customer extends Users {

    Customer(String username, String password) {
        super(username, password);
    }

    @Override
    void postLogin() {
        System.out.println("Customer Logged in with username : " + username);
    }
}

class Admin extends Users {

    Admin(String username, String password) {
        super(username, password);
    }

    @Override
    void postLogin() {
        System.out.println("Admin logged in with username : " + username);
    }
}

interface Login{
    static String usrname = "";
    void postLogin();
}