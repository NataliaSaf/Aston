package org.example;

public class Main {
    public static void main(String[] args) {
        Employee[] person = new Employee[5];
        person[0] = new Employee("Antonov Sergey", "director", "antserg@mailbox.com", "89631751245", 150000, 47);
        person[1] = new Employee("Vasilyeva Elena", "accountant", "vaselena@mailbox.com", "89030785327", 75000, 41);
        person[2] = new Employee("Baranova Irina", "cashier", "barina@mailbox.com", "89065782803", 40000, 35);
        person[3] = new Employee("Nikolaev Alexey", "manager", "nikolalex@mailbox.com", "89530864952", 65000, 32);
        person[4] = new Employee("Vorotnikov Andrey", "driver", "vorotnik@mailbox.com", "89027260168", 35000, 28);
        for (Employee employee : person) {
            employee.printInfo();
        }

          Park park = new Park("Парк Гагарина", 1);
          park.addAttraction(0, "Калипсо", "10:00 - 17:00", 500);

          park.printAttractions();
    }

}



