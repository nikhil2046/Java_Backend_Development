package com.exercise.programs.inheritance_programs;

public class Interview_02 {
    public static void main(String[] args) {
        CC a = new CC();
        a.callAdd();
    }
}
class AA{
    void add(){
        System.out.println("Class AA");
    }
}
class BB extends AA{
    void add(){
        System.out.println("Class BB");
    }
    void callAdd(){
        super.add();
    }
}
class CC extends BB{
    void add(){
        System.out.println("Class CC");
    }
    void callAdd(){
        super.callAdd();
    }
}
