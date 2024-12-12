package org.example;

public class MyArray {
    public int methodArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Неправильный размер массива: должно быть 4 строки");
        }
        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("Неправильный размер массива: должно быть 4 столбца");
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка преобразования в ячейке [" + i + "][" + j + "]");
                }
            }
        }
        return sum;
    }
}