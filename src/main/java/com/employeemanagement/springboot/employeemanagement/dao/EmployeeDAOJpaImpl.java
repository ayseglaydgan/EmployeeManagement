package com.employeemanagement.springboot.employeemanagement.dao;

import com.employeemanagement.springboot.employeemanagement.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> employeeQuery = entityManager.createQuery("FROM Employee",Employee.class);
        return employeeQuery.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        Employee dbEmployee =  entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void deleteEmployee(int id) {
        Employee theEmployee = entityManager.find(Employee.class, id);
        entityManager.remove(theEmployee);
    }


}
