package com.zdl.demo.dao.impl;

import com.zdl.demo.dao.EmployeeDao;
import com.zdl.demo.dao.repository.EmployeeRepository;
import com.zdl.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(String s) {
        return employeeRepository.findById(s);
    }
}
