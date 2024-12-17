package org.example;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       SetWords setWords = new SetWords();
       setWords.findWords();

       PhoneDirectory phoneDirectory = new PhoneDirectory();
       phoneDirectory.add("Антонов", "+79521063587");
       phoneDirectory.add("Бородин", "+79065892314");
       phoneDirectory.add("Варганов", "+79027594612");
       phoneDirectory.add("Тарелкин", "+79084233566");
       phoneDirectory.add("Варганов", "+79630258752");

       System.out.println(phoneDirectory.get("Антонов"));
       System.out.println(phoneDirectory.get("Бородин"));
       System.out.println(phoneDirectory.get("Варганов"));
       System.out.println(phoneDirectory.get("Тарелкин"));
    }
}
