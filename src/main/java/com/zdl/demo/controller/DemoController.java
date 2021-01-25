package com.zdl.demo.controller;

import com.zdl.demo.dao.EmployeeDao;
import com.zdl.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/test")
public class DemoController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/add")
    public String add() {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setFirstName("xuxu");
        employee.setLastName("zh");
        employee.setAge(26);
        employee.setAbout("i am in peking");
        employeeDao.save(employee);
        System.err.println("add a obj");
        return "success";
    }

    @GetMapping("/get")
    public Employee get() {
        Optional<Employee> byId = employeeDao.findById("1");
        return byId.get();
    }
}
