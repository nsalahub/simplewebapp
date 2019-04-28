package com.gmail.salahub.nikolay.simplewebapp.dao;

import com.gmail.salahub.nikolay.simplewebapp.dao.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee);

    void deleteEmployeeById(Long id);

    void updateEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    List<Employee> getEmployees();
}
