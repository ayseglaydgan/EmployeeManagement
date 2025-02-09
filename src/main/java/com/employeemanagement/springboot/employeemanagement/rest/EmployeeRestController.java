package com.employeemanagement.springboot.employeemanagement.rest;

import com.employeemanagement.springboot.employeemanagement.entity.Employee;
import com.employeemanagement.springboot.employeemanagement.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees")
    public List<Employee> getEmployees()
    {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null)
        {
            throw new RuntimeException("Employee id not found -" + employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee)
    {
        employee.setId(0);
        Employee dbEmpolyee = employeeService.saveEmployee(employee);
        return dbEmpolyee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        Employee dbEmpolyee = employeeService.saveEmployee(employee);
        return dbEmpolyee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        Employee employee = employeeService.findById(employeeId);

        if(employee == null)
        {
            throw new RuntimeException("Employee doesnot exist.");
        }

        employeeService.deleteEmployee(employeeId);

        return "Deleted employee success";

    }
}
