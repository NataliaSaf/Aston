package org.example;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Вызов методов
        printThreeWords();//Задача 1
        checkSumSign();//Задача 2
        printColor();//Задача 3
        compareNumbers();//Задача 4
        System.out.println(sumInRange(5,10));//Задача 5
        numberSign(-5);//Задача 6
        System.out.println(sumInRange(10));//Задача 7
        printString("Здравствуйте",4);//Задача 8
        System.out.println(leapYear (1920));//Задача 9
        replaceArray();//Задача 10
        fillArray();//Задача 11
        multiplyNumber();//Задача 12
        fillDiagonal();//Задача 13
        retLenArray();//Задача 14
    }

    //Задача 1
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    //Задача 2
    public static void checkSumSign() {
        int a = 5;
        int b = 7;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {System.out.println("Сумма отрицательная");
        }
    }
    //Задача 3
    public static void printColor() {
        int value = 75;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
    //Задача 4
    public static void compareNumbers() {
        int a = 5;
        int b = 10;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    //Задача 5
    public static boolean sumInRange(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }
    //Задача 6
    public static void numberSign(int num) {
        if (num >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }
    //Задача 7
    public static boolean sumInRange(int num) {
        if (num < 0) {
            return true;
        } else {
            return false;
        }
    }
    //Задача 8
    public static void printString (String str, int kol) {
        for (int i = 0; i < kol; i++) {
            System.out.println(str);
        }
    }
    //Задача 9
    public static boolean leapYear (int year) {
        if (year % 400 == 0 && year % 4 == 0) {
            return true;
        } else if (year % 100 == 0){
            return false;
        } else {
            return year % 4 == 0;
        }
    }
    //Задача 10
    public static void replaceArray() {
        int [] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else if (array[i] == 1) {
                array[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array));
    }
    //Задача 10
    public static void fillArray() {
        int[] array = new int[100];
        int value = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }
    //Задача 12
    public static void multiplyNumber() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *=2;
            }
        }
        System.out.println(Arrays.toString(array));
    }
    //Задача 13
    public static void fillDiagonal() {
        int a = 5; //размер массива
        int [][] array = new int[a][a];
        for (int i = 0; i < a; i++) {
            array[i][i] = 1;
            array[i][a - i - 1] = 1;
        }
        for (int i = 0; i < a; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
    //Задача 14
    public static void retLenArray() {
        int len = 12; int initialValue = 4;
        int[] array = new int [len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }System.out.println(Arrays.toString(array));

    }
    }
