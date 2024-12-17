package org.example;

public class FoodBowl {
    private int food;

    public FoodBowl(int food){
        this.food = food;
    }
    public  int getFood(){
        return food;
    }
    public void decreaseFood(int amount) {
        if (food >= amount){
            food += amount;
        }
    }
    public void addFood(int amount) {
        food += amount;
        System.out.println("В миску добавлено " + amount + " количество еды");
    }
}
