package com.gmail.salahub.nikolay.simplewebapp.service;

import com.gmail.salahub.nikolay.simplewebapp.dao.model.Employee;
import com.gmail.salahub.nikolay.simplewebapp.service.dto.EmployeeDTO;

public interface EmployeeConverter {

    Employee fromDTO(EmployeeDTO employeeDTO);

    EmployeeDTO toDTO(Employee employee);
}
