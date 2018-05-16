package com.yorix.hillel.java_elementary.task34;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<Employee> employees = Arrays.asList(
            new Employee("Коля", 20_000_00L, 42, Gender.MALE, false),
            new Employee("Валя", 26_000_00L, 27, Gender.FEMALE, true),
            new Employee("Гена", 7_000_00L, 34, Gender.MALE, false),
            new Employee("Витя", 30_000_00L, 27, Gender.MALE, true),
            new Employee("Маша", 12_000_00L, 36, Gender.FEMALE, true),
            new Employee("Вика", 45_000_00L, 51, Gender.FEMALE, false),
            new Employee("Олег", 5_000_00L, 48, Gender.MALE, true),
            new Employee("Коля", 14_000_00L, 50, Gender.MALE, false),
            new Employee("Валя", 8_000_00L, 19, Gender.FEMALE, false),
            new Employee("Стёпа", 5_000_00L, 35, Gender.MALE, true),
            new Employee("Саша", 9_000_00L, 22, Gender.MALE, false)
    );

    public static List<Employee> getEmployees() {
        return employees;
    }

    public static void main(String[] args) {


        System.out.println("\nполучить первого женатого мужчину + вывести его имя в консоль");
        employees.stream()
                .filter(employee -> employee.getGender().equals(Gender.MALE) && employee.isMarried())
                .limit(1)
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("\nполучить любую незамужнюю женщину + вывести её имя в консоль");
        employees.stream()
                .filter(employee -> employee.getGender().equals(Gender.FEMALE) && !employee.isMarried())
                .findAny()
                .map(Employee::getName)
                .ifPresent(System.out::println);

        System.out.println("\n>45 лет и только мужчин + вывести их имена в консоль");
        employees.stream()
                .filter(employee -> employee.getGender().equals(Gender.MALE) && employee.getAge() > 45)
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("\n<30 лет и только женщин + вывести их имена в консоль");
        employees.stream()
                .filter(employee -> employee.getGender().equals(Gender.FEMALE) && employee.getAge() < 30)
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("\nмежду 33 и 37 годами как мужчин так и женщин + вывести их имена в консоль");
        employees.stream()
                .filter(employee -> employee.getAge() > 33 && employee.getAge() < 37)
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("\nточное количество незамужних женщин + вывести это кол-во в консоль");
        long count = employees.stream()
                .filter(employee -> employee.getGender().equals(Gender.FEMALE) && !employee.isMarried())
                .count();
        System.out.println(count);

        System.out.println("\nполучить только зарплаты мужчин старше 30 лет + вывести каждую ЗП в консоль");
        employees.stream()
                .filter(employee -> employee.getGender().equals(Gender.MALE))
                .filter(employee -> employee.getAge() > 30)
                .map(Employee::getSalary)
                .forEach(System.out::println);

        System.out.println("\nполучить сотрудников только с уникальными именами + вывести в консоль их имена");
        employees.stream()
                .map(Employee::getName)
                .distinct()
                .forEach(System.out::println);
    }
}
