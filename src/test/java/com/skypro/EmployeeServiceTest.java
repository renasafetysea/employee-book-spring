package com.skypro;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import com.skypro.employee.service.BadRequestException;
import com.skypro.employee.service.EmployeeService;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EmployeeServiceTest {

    private EmployeeService employeeService;
    private EmployeeRequest employeeWrongEnter;
    private EmployeeRequest Ivanov;
    private EmployeeRequest Petrov;
    private EmployeeRequest Sidorov;
    private EmployeeRequest Rybakov;
    private EmployeeRequest Smirnov;

    @BeforeAll
    public void setUp(){
        Ivanov = new EmployeeRequest("Ivanov", "Ivan", 2, 10000);
        Petrov = new EmployeeRequest("Petrov", "Petr", 2, 11000);
        Sidorov = new EmployeeRequest("Sidorov", "Sidr", 2, 12000);
        Rybakov = new EmployeeRequest("Ribakov", "Ri", 1, 15000);
        Smirnov = new EmployeeRequest("Smirnov", "Si", 1, 20000);

        employeeService = new EmployeeService();
        employeeService.addEmployee(Ivanov);
        employeeService.addEmployee(Petrov);
        employeeService.addEmployee(Sidorov);
        employeeService.addEmployee(Rybakov);
        employeeService.addEmployee(Smirnov);

        employeeWrongEnter = new EmployeeRequest(null, "Petr", 0, 0);

    }

    @Test
    public void addEmployeeTest() {
        Assertions.assertThrows(BadRequestException.class, () -> employeeService.addEmployee(employeeWrongEnter));
    }

    @Test
    public void getSalarySumTest() {
        assertEquals(170000, employeeService.getSalarySum());
    }

    @Test
    void getSalaryMin() {
        assertEquals(6000, employeeService.getSalaryMin());
    }
    @Test
    void getSalaryMax() {
        assertEquals(8000, employeeService.getSalaryMax());
    }

    @Test
    void getHighSalary() {
        assertIterableEquals(List.of(Petrov), employeeService.getHighSalary());
    }
}
