package com.employeemanagement.springboot.employeemanagement.dao;

import com.employeemanagement.springboot.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //CRUD methods for free from JPA
}
