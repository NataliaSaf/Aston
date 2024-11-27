package org.example;

public class Park {
    String name;

    public Park(String name) {
        this.name = name;
    }
     public class Attraction {
        String attractionName;
        String workingTime;
        int cost;
        public Attraction(String attractionName, String workingTime, int cost) {
            this.attractionName = attractionName;
            this.workingTime = workingTime;
            this.cost = cost;
        }
        public void printInfo() {
            System.out.println("Название аттракциона: " + attractionName);
            System.out.println("Время работы: " + workingTime);
            System.out.println("Стоимость: " + cost);
        }
     }
}
