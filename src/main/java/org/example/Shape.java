package org.example;

public interface Shape {
    String getFillColor();
    String getBorderColor();
    double calculatePerimeter();
    double calculateArea();

    default void printInfo(){
        System.out.println("Периметр: " + calculatePerimeter() + " м.");
        System.out.println("Площадь: " + calculateArea() + " м^2.");
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }
}
