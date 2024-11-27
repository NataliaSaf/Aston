package org.example;

public class Employee {
    String fullName;
    String position;
    String email;
    String phone;
    int salary;
    int age;

    public Employee(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public void printInfo(){
        System.out.println("ФИО: " + fullName);
        System.out.println("должность: " + position);
        System.out.println("email: " + email);
        System.out.println("телефон: " + phone);
        System.out.println("зарплата: " + salary);
        System.out.println("возраст: " + age);
    }
}
