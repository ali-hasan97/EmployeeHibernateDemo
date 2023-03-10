package com.genspark.HibernateDemoApplication.Dao;

import com.genspark.HibernateDemoApplication.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
