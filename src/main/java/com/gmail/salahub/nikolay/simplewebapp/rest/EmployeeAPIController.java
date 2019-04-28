package com.gmail.salahub.nikolay.simplewebapp.rest;

import com.gmail.salahub.nikolay.simplewebapp.service.EmployeeService;
import com.gmail.salahub.nikolay.simplewebapp.service.dto.EmployeeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("simplewebapi/employee")
public class EmployeeAPIController {

    private Logger logger = LoggerFactory.getLogger(EmployeeAPIController.class);

    private EmployeeService employeeService;

    private Map<Integer, EmployeeDTO> employeeDTOMap = new HashMap<>();

    @Autowired
    private EmployeeAPIController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<List<EmployeeDTO>> showEmployees() {
        List<EmployeeDTO> employees = employeeService.findEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("/save")
    public void saveEmployee(
            @RequestBody EmployeeDTO employeeDTO
    ) {
        employeeService.saveEmployee(employeeDTO);
    }

    @PostMapping("/update/{id}")
    public void updateEmployeeById(
            @RequestBody EmployeeDTO employeeDTO,
            @PathVariable(name = "id") Long id) {
        employeeService.updateEmployee(employeeDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEmployeeById(
            @PathVariable(name = "id") Long id) {
        employeeService.removeEmployeeById(id);
    }

    @PostMapping("/get/emplooyee")
    public ResponseEntity<EmployeeDTO> getEmployee(
            @PathVariable(name = "id") Long id
    ) {
        EmployeeDTO employees = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}