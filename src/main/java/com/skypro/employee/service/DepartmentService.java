package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }




    public Collection<Employee> getEmployeeByDepartments(int department){
        return getEmployeesByDepartmentStream(department)
                .collect(Collectors.toList());
    }

    public int getSumOfSalaryOfDepartment(int department){
        return getEmployeesByDepartmentStream(department)
                .mapToInt(Employee::getSalary)
                .sum();
    }
    public int getMaxSalaryByDepartment(int department){
        return getEmployeesByDepartmentStream(department)
                .mapToInt(Employee::getSalary)
                .max()
                .orElse(0);

    }
    public int getMinSalaryByDepartment(int department){
        return getEmployeesByDepartmentStream(department)
                .mapToInt(Employee::getSalary)
                .min()
                .orElse(0);

    }
    public Map<Integer, List<Employee>> getEmployeeGroupedByDepartments(){
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    private Stream<Employee> getEmployeesByDepartmentStream(int department){
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department);
    }
}
