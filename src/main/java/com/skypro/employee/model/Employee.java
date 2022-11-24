package com.skypro.employee.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class Employee {
    private static int counter;
    private final int id;
    private final String firstName;
    private final String lastName;

    private final int department;
    private final double salary;

    public Employee(String firstName, String lastName, int department, double salary) {
        if (StringUtils.isAlpha(firstName) && !StringUtils.isAllBlank(firstName)) {
            this.firstName = StringUtils.capitalize(firstName);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isAlpha(lastName) && !StringUtils.isAllBlank(lastName)) {
            this.lastName = StringUtils.capitalize(lastName);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
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
