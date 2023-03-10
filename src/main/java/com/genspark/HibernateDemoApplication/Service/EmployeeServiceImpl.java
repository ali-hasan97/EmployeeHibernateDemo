package com.genspark.HibernateDemoApplication.Service;

import com.genspark.HibernateDemoApplication.Dao.EmployeeDao;
import com.genspark.HibernateDemoApplication.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeDao.findAll();
    }

    @Override
    public Employee getEmployeeByID(int employeeID) {
        Optional <Employee> c = this.employeeDao.findById(employeeID);
        Employee employee = null;
        if (c.isPresent()) {
            employee = c.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + employeeID);
        }
        return employee;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return this.employeeDao.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return this.employeeDao.save(employee);
    }

    public String deleteEmployeeByID(int employeeID) {
        this.employeeDao.deleteById(employeeID);
        return "Deleted Successfully";
    }
}
