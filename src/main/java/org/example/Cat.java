package org.example;

public class Cat extends Animal{
    private String name;
    static int countCat = 0;
    private boolean full;

    public Cat(String name){
        countCat++;
        this.name = name;
    }

    @Override
    public void run(int distance){
        if (distance > 200){
            System.out.println(name + " не может бегать больше 200 м.");
        } else {
            System.out.println(name + " пробежал " + distance + " м.");
        }
    }
    @Override
    public void swim (int distance){
        System.out.println(name + " не умеет плавать");
    }

    public void eat(FoodBowl foodBowl, int amount){
        if (foodBowl.getFood() >= amount){
            foodBowl.decreaseFood(amount);
            this.full = true;
            System.out.println(name + " покушал " + amount + " количество еды");
        } else {
            System.out.println(name + " не хватило еды");
        }
    }
    public  boolean isFull(){
        return full;
    }
}
