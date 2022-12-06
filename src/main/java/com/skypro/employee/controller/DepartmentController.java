package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public Collection<Employee> getEmployeeByDepartments(int department) {
        return departmentService.getEmployeeByDepartments(department);
    }
    @GetMapping("/{id}/salary/sum")
    public int getSalarySumOfDepartment(@PathVariable("id") int department){
        return departmentService.getSumOfSalaryOfDepartment(department);
    }
    @GetMapping("/{id}/salary/min")
    public int getSalaryMinOfDepartment(@PathVariable("id") int department){
        return departmentService.getMinSalaryByDepartment(department);
    }
    @GetMapping("/{id}/salary/max")
    public int getSalaryMaxOfDepartment(@PathVariable("id") int department){
        return departmentService.getMaxSalaryByDepartment(department);
    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployeesGroupedByDepartment() {
        return departmentService.getEmployeeGroupedByDepartments();
    }

}
