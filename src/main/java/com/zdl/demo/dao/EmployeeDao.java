package com.zdl.demo.dao;

import com.zdl.demo.entity.Employee;

import java.util.Optional;

public interface EmployeeDao {
    void save(Employee employee);

    Optional<Employee> findById(String s);
}
