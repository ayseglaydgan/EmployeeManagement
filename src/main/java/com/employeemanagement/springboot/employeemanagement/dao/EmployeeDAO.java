package com.employeemanagement.springboot.employeemanagement.dao;

import com.employeemanagement.springboot.employeemanagement.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee saveEmployee(Employee employee);


    void deleteEmployee(int id);


}
