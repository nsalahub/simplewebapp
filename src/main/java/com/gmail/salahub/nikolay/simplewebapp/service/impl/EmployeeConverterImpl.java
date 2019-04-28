package com.gmail.salahub.nikolay.simplewebapp.service.impl;

import com.gmail.salahub.nikolay.simplewebapp.dao.model.Employee;
import com.gmail.salahub.nikolay.simplewebapp.service.EmployeeConverter;
import com.gmail.salahub.nikolay.simplewebapp.service.dto.EmployeeDTO;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverterImpl implements EmployeeConverter {
    @Override
    public Employee fromDTO(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setDepartmentId(employeeDTO.getDepartmentId());
        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setGender(employeeDTO.getGender());
        employee.setDeleted(employeeDTO.getDeleted());
        employee.setJobTitle(employeeDTO.getJobTitle());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        return employee;
    }

    @Override
    public EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setGender(employee.getGender());
        employeeDTO.setEmployeeId(employee.getEmployeeId());
        employeeDTO.setJobTitle(employee.getJobTitle());
        employeeDTO.setDeleted(employee.getDeleted());
        employeeDTO.setDepartmentId(employee.getDepartmentId());
        employeeDTO.setDateOfBirth(employee.getDateOfBirth());
        return employeeDTO;
    }
}
