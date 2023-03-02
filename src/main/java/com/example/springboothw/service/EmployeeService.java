package com.example.springboothw.service;

import com.example.springboothw.entity.Employee;

import java.util.List;


public interface EmployeeService {
    List<Employee> getAll();
    Employee getById(int id);
    void add(Employee employee);
    void update(Employee employee);
    void removeById(int id);
}