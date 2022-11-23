package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();

   public Collection<Employee> getAllEmployees(){
       return this.employees.values();

    }

    public Employee addEmployee(EmployeeRequest employeeRequest){
       if(employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null){
           throw new IllegalArgumentException("Employee name should be sat");
       }
        Employee employee = new Employee(
                employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());

        this.employees.put(employee.getId(), employee);
        return employee;


    }

    public double getSalarySum(){
        return employees.values().stream().mapToDouble(Employee::getSalary).sum();
    }

    public double getSalaryMin(){
        return employees.values().stream().mapToDouble(Employee::getSalary).min().orElse(0);
    }
    public double getSalaryMax() {
        return employees.values().stream().mapToDouble(Employee::getSalary).max().orElse(0);
    }
    public List<Employee> getHighSalary() {
       double highSalary = employees.values().stream().mapToDouble(Employee::getSalary).average().orElseThrow();
        return employees.values().stream().filter(e -> e.getSalary() > highSalary).collect(Collectors.toList());
    }
}
