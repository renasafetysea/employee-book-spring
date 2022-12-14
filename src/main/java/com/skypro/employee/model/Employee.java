package com.skypro.employee.model;

public class Employee {
    private static int counter;
    private final int id;
    private final String firstName;
    private final String lastName;

    private final int department;
    private final double salary;

    public Employee(String firstName, String lastName, int department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.id = counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Сотрудник :" +
                " id - " + id +
                "Имя - " + firstName + '\'' +
                "Фамилия - " + lastName + '\'' +
                ", департамент № " + department +
                ", зарплата - " + salary +
                " руб.";
    }
}
