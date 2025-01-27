package com.employeemanagement.springboot.employeemanagement.dao;

import com.employeemanagement.springboot.employeemanagement.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    void addEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(int id);


}
