package com.employeemanagement.springboot.employeemanagement.service;

import com.employeemanagement.springboot.employeemanagement.dao.EmployeeDAO;
import com.employeemanagement.springboot.employeemanagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
        this.employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id)
    {
        return employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.saveEmployee(employee);
    }

    @Transactional
    @Override
    public String deleteEmployee(int id) {

        Employee theEmployee = employeeDAO.findById(id);
        if(theEmployee == null)
        {
            throw new RuntimeException("Employee id not found -" + id);
        }

        employeeDAO.deleteEmployee(id);
        return "Deleted employee id -" + id;
    }


}
