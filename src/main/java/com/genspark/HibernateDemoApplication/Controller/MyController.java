package com.genspark.HibernateDemoApplication.Controller;

import com.genspark.HibernateDemoApplication.Entity.Employee;
import com.genspark.HibernateDemoApplication.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class MyController {

    // autowired because EmployeeService class is being injected into MyController class
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public String home() {
        return "<HTML><H1>Welcome to Employee Application</H1></HTML>";
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeID}")
    public Employee getEmployeeByID(@PathVariable String employeeID) {
        return this.employeeService.getEmployeeByID(Integer.parseInt(employeeID));
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return this.employeeService.addEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return this.employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeID}")
    public String deleteEmployee(@PathVariable String employeeID) {
        return this.employeeService.deleteEmployeeByID(Integer.parseInt(employeeID));
    }
}
