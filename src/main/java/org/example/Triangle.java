package org.example;

public class Triangle implements Shape{
    private double side1;
    private double side2;
    private double side3;
    private String fillColor;
    private String borderColor;

    public Triangle(double side1, double side2, double side3, String fillColor, String borderColor){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    @Override
    public double calculatePerimeter(){
        return side1 + side2 + side3;
    }
    @Override
    public double calculateArea(){
         double a = calculatePerimeter() / 2;
        return Math.sqrt(a * (a - side1) * (a - side2) * (a - side3));
    }
    @Override
    public String getFillColor(){
        return fillColor;
    }
    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
