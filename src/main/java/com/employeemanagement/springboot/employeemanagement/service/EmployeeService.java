package com.employeemanagement.springboot.employeemanagement.service;

import com.employeemanagement.springboot.employeemanagement.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee saveEmployee(Employee employee);

    void deleteEmployee(int id);
}
