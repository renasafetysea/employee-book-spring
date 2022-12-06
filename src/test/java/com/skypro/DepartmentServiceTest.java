package com.skypro;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import com.skypro.employee.service.DepartmentService;
import com.skypro.employee.service.EmployeeService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DepartmentServiceTest {

    private final EmployeeService employeeServiceMockito = mock(EmployeeService.class);

    @InjectMocks
    private DepartmentService departmentService;
    private List<Employee> list;
    private Employee Ivanov;
    private Employee Petrov;
    private Employee Sidorov;
    private Employee Rybakov;
    private Employee Smirnov;



    @BeforeAll
    public void setUp(){
        Ivanov = new Employee("Ivanov", "Ivan", 2, 10000);
        Petrov = new Employee("Petrov", "Petr", 2, 11000);
        Sidorov = new Employee("Sidorov", "Sidr", 2, 12000);
        Rybakov = new Employee("Ribakov", "Ri", 1, 15000);
        Smirnov = new Employee("Smirnov", "Si", 1, 20000);

        list = List.of(Ivanov, Petrov, Sidorov, Rybakov, Smirnov);

        Mockito.when(employeeServiceMockito.getAllEmployees()).thenReturn(list);
    }

    @Test
    public void departmentOneEmployees() {
        Assertions.assertEquals(List.of(Ivanov, Sidorov), departmentService.getEmployeeByDepartments(1));
    }

    @Test
    public void departmentTwoEmployees() {
        Assertions.assertEquals(List.of(Petrov, Rybakov), departmentService.getEmployeeByDepartments(2));
    }
    @Test
    public void getDepartmentTwoSum() {
        Assertions.assertEquals(48000, departmentService.getSumOfSalaryOfDepartment(2));
    }


    @Test
    public void getEmployeeSalaryOneMin() {
        Assertions.assertEquals(6000, departmentService.getMinSalaryByDepartment(1));
    }

    @Test
    public void getEmployeeSalaryTwoMax() {
        Assertions.assertEquals(25000, departmentService.getMaxSalaryByDepartment(2));
    }

}