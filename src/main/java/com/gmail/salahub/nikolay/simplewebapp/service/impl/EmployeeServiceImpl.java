package com.gmail.salahub.nikolay.simplewebapp.service.impl;

import com.gmail.salahub.nikolay.simplewebapp.dao.EmployeeDao;
import com.gmail.salahub.nikolay.simplewebapp.dao.model.Employee;
import com.gmail.salahub.nikolay.simplewebapp.service.EmployeeService;
import com.gmail.salahub.nikolay.simplewebapp.service.EmployeeConverter;
import com.gmail.salahub.nikolay.simplewebapp.service.dto.EmployeeDTO;
import com.gmail.salahub.nikolay.simplewebapp.service.exception.EmployeeServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private static final String FIND_ALL_EMPLOYEES_ERROR_MESSAGE = "Getting employee failed!";
    private static final String ADD_EMPLOYEE_ERROR_MESSAGE = "Add employee failed!";
    private static final String DELETE_EMPLOYEE_ERROR_MESSAGE = "Delete employee failed!";
    private static final String UPDATE_EMPLOYEE_ERROR_MESSAGE = "Update employee failed!";
    private static final String FIND_ANY_EMPLOYEE_ERROR_MESSAGE = "Find employee failed!";

    @Autowired
    private EmployeeConverter employeeConverter;
    private EmployeeDao employeeDao;

    private EmployeeServiceImpl(EmployeeConverter employeeConverter, EmployeeDao employeeDao) {
        this.employeeConverter = employeeConverter;
        this.employeeDao = employeeDao;
    }

    @Override
    public void saveEmployee(EmployeeDTO employee) {
        try {
            employeeDao.addEmployee(employeeConverter.fromDTO(employee));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new EmployeeServiceException(ADD_EMPLOYEE_ERROR_MESSAGE, e);
        }
    }

    @Override
    public void removeEmployeeById(Long id) {
        try {
            employeeDao.deleteEmployeeById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new EmployeeServiceException(DELETE_EMPLOYEE_ERROR_MESSAGE, e);
        }
    }

    @Override
    public void updateEmployee(EmployeeDTO employee) {
        try {
            employeeDao.updateEmployee(employeeConverter.fromDTO(employee));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new EmployeeServiceException(UPDATE_EMPLOYEE_ERROR_MESSAGE, e);
        }
    }

    @Override
    public EmployeeDTO findEmployeeById(Long id) {
        EmployeeDTO employeeDTO;
        try {
            employeeDTO = employeeConverter.toDTO(
                    employeeDao.getEmployeeById(id));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new EmployeeServiceException(FIND_ANY_EMPLOYEE_ERROR_MESSAGE, e);
        }
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> findEmployees() {
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        try {
            List<Employee> employees = employeeDao.getEmployees();
            for (Employee employee : employees) {
                employeeDTOS.add(employeeConverter.toDTO(employee));
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new EmployeeServiceException(FIND_ALL_EMPLOYEES_ERROR_MESSAGE, e);
        }
        return employeeDTOS;
    }
}
