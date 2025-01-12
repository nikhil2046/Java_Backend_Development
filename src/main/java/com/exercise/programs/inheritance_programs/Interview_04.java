package com.exercise.programs.inheritance_programs;

public class Interview_04 {
    public static void main(String[] args) {
        Engine petrolEngine = new PetrolEngine();

        Engine electricEngine = new ElectricEngine();

        petrolEngine.start();
        electricEngine.stp();

    }
}

interface Engine{
    void start();
    void stp();

}

class PetrolEngine implements Engine{

    @Override
    public void start() {
        System.out.println("Petrol engine start");
    }

    @Override
    public void stp() {
        System.out.println("Petrol engine stop");
    }
}

class ElectricEngine implements Engine{

    @Override
    public void start() {
        System.out.println("Electric engine start");
    }

    @Override
    public void stp() {
        System.out.println("Electric engine Stop");
    }
}

class Car{
    private Engine engine;
   public Car(Engine engine){
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}