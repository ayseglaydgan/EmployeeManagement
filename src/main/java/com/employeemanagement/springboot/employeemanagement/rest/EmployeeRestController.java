package com.employeemanagement.springboot.employeemanagement.rest;

import com.employeemanagement.springboot.employeemanagement.dao.EmployeeDAO;
import com.employeemanagement.springboot.employeemanagement.entity.Employee;
import com.employeemanagement.springboot.employeemanagement.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }
    //private EmployeeDAO employeeDAO;
    /* public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
        this.employeeDAO = theEmployeeDAO;
    }*/

    @GetMapping("/employee")
    public List<Employee> getEmployees()
    {

        return employeeService.findAll();
    }
}
