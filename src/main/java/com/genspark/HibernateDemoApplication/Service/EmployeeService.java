package com.genspark.HibernateDemoApplication.Service;

import com.genspark.HibernateDemoApplication.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeByID(int employeeID);

    Employee addEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    String deleteEmployeeByID(int employeeID);
}
