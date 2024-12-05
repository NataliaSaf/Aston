package org.example;

public abstract class Animal {
    protected static int countAnimal = 0;
    public Animal(){
        countAnimal++;
    }
    public abstract void run (int distance);
    public abstract void swim (int distance);
    }

