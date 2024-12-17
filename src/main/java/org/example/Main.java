package org.example;

public class Main {
    public static void main(String[] args) {
        // Задача 1
        Cat cat1 = new Cat("Туман");
        Cat cat2 = new Cat("Дымок");
        Cat cat3 = new Cat("Агат");

        Dog dog1 = new Dog("Вулкан");
        Dog dog2 = new Dog("Изюм");
        Dog dog3 = new Dog("Лёва");
        // Бег и плавание_коты
        cat1.run(100);
        cat2.run(210);
        cat3.swim(5);
        // Бег и плавание_собаки
        dog1.run(400);
        dog2.run(550);
        dog3.swim(5);
        dog3.swim(15);
        //Проверка сытости
        FoodBowl foodBowl = new FoodBowl(10);

        Cat[] cats = {cat1, cat2, cat3};
        for (Cat cat : cats) {
            cat.eat(foodBowl, 15);
            System.out.println("Сытость кота " + cat.isFull());
        }

        System.out.println("Количество котов: " + Cat.countCat);
        System.out.println("Количество собак: " + Dog.countDog);
        System.out.println("Количество животных: " + Animal.countAnimal);

        //Задача 2
        Shape circle = new Circle(6.0, "жёлтый", "красный");
        Shape restangle = new Restangle(5.0, 4.0,"зелёный","синий");
        Shape triangle = new Triangle(6.0, 6.0, 8.0,",белый", "розовый");

        System.out.println("Характеристика круга:");
        circle.printInfo();
        System.out.println();

        System.out.println("Характеристика прямоугольника:");
        restangle.printInfo();
        System.out.println();

        System.out.println("Характеристика треугольника:");
        triangle.printInfo();
        System.out.println();
    }
}



