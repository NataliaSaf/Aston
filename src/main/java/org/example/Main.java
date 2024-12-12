package org.example;

public class Main {
    private static MyArray myArray;

    public static void main(String[] arrgs) {
        MyArray myArray = new MyArray();

       String[][] array = new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};

       try{
           int result = myArray.methodArray(array);
           System.out.println("Сумма элементов массива: " + result);
       } catch (MyArraySizeException | MyArrayDataException e) {
           System.out.println("Ошибка: " + e.getMessage());
       }
    }
}



