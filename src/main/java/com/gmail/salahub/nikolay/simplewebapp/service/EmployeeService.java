package com.gmail.salahub.nikolay.simplewebapp.service;

import com.gmail.salahub.nikolay.simplewebapp.dao.model.Employee;
import com.gmail.salahub.nikolay.simplewebapp.service.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(EmployeeDTO employee);

    void removeEmployeeById(Long id);

    void updateEmployee(EmployeeDTO employee);

    EmployeeDTO findEmployeeById(Long id);

    List<EmployeeDTO> findEmployees();
}
