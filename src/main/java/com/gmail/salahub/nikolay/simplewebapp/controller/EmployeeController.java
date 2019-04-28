package com.gmail.salahub.nikolay.simplewebapp.controller;

import com.gmail.salahub.nikolay.simplewebapp.dao.model.Employee;
import com.gmail.salahub.nikolay.simplewebapp.service.EmployeeService;
import com.gmail.salahub.nikolay.simplewebapp.service.dto.EmployeeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeController {
    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("simplewebapi/employee")
    public String showEmployee(Model model, Model addModel) {
        List<EmployeeDTO> employees = employeeService.findEmployees();
        EmployeeDTO employee = new EmployeeDTO();
        addModel.addAttribute("employee", employee);
        model.addAttribute("employees", employees);
        logger.info(employees.get(0).getFirstName());
        return "employee";
    }

    @PostMapping("simplewebapi/employee/save")
    public String addEmployee(
            @Valid EmployeeDTO employeeDTO,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "items";
        }
        employeeService.saveEmployee(employeeDTO);
        return "redirect:employee";
    }

    @PostMapping("simplewebapi/employee/update")
    public String updateItem(
            EmployeeDTO employeeDTO
    ) {
        employeeService.updateEmployee(employeeDTO);
        return "redirect:items";
    }
}
