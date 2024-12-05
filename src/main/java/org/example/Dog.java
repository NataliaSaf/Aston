package org.example;

public class Dog extends Animal{
    public String name;
    static int countDog = 0;

    public Dog(String name){
        countDog++;
        this.name = name;
    }
    @Override
    public void run(int distance){
        if (distance > 500){
            System.out.println(name + " не может бегать больше 500 м.");
        } else {
            System.out.println(name + " пробежал " + distance + " м.");
        }
    }
    @Override
    public void swim (int distance){
        if (distance > 10){
            System.out.println(name + " не может проплыть больше 10 м.");
        } else {
            System.out.println(name + " проплыл " + distance + " м.");
        }
    }
    public static int getCountDog(){
        return countDog;
    }
}
