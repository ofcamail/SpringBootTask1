package com.example.springboothw.controller;
import com.example.springboothw.entity.Employee;
import com.example.springboothw.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("skypro")
public class RestControl {

    private EmployeeService employeeService;

    public RestControl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getById(id);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employeeService.add(employee);

        return employee;
    }


    @PatchMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.update(employee);

        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable int id){
        employeeService.removeById(id);

        return "Employee with id: " + id + " deleted";
    }
}