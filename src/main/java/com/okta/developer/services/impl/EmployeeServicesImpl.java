package com.okta.developer.services.impl;

import com.okta.developer.entity.Employee;
import com.okta.developer.services.EmployeeServices;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class EmployeeServicesImpl implements EmployeeServices {
    @PersistenceContext(unitName = "beer-pu")
    private EntityManager entityManager;

    final String  QUERY= "SELECT E FROM Employee E";

    @Override
    public List<Employee> getAllEmployee() {

        return entityManager.createQuery(QUERY, Employee.class).getResultList();

    }
}
