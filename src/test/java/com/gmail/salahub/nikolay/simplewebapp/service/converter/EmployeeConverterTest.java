package com.gmail.salahub.nikolay.simplewebapp.service.converter;

import com.gmail.salahub.nikolay.simplewebapp.dao.model.Employee;
import com.gmail.salahub.nikolay.simplewebapp.service.EmployeeConverter;
import com.gmail.salahub.nikolay.simplewebapp.service.dto.EmployeeDTO;
import com.gmail.salahub.nikolay.simplewebapp.service.impl.EmployeeConverterImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployeeConverterTest {

    EmployeeConverter employeeConverter;

    @Before
    public void init() {
        employeeConverter = new EmployeeConverterImpl();
    }

    @Test
    public void shouldReturnEmployeeWithSomeId() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(1L);
        Employee employee = employeeConverter.fromDTO(employeeDTO);
        Assert.assertEquals(employeeDTO.getEmployeeId(), employee.getEmployeeId());
    }

    @Test
    public void shouldReturnEmployeeWithSomeFirstName() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName("first_name");
        Employee employee = employeeConverter.fromDTO(employeeDTO);
        Assert.assertEquals(employeeDTO.getFirstName(), employee.getFirstName());
    }

    @Test
    public void shouldReturnEmployeeDTOWithSomeFirstName() {
        Employee employee = new Employee();
        employee.setFirstName("first_name");
        EmployeeDTO employeeDTO = employeeConverter.toDTO(employee);
        Assert.assertEquals(employee.getFirstName(), employeeDTO.getFirstName());
    }
}
