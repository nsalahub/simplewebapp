package com.gmail.salahub.nikolay.simplewebapp.controller;

import com.gmail.salahub.nikolay.simplewebapp.dao.model.Gender;
import com.gmail.salahub.nikolay.simplewebapp.service.EmployeeService;
import com.gmail.salahub.nikolay.simplewebapp.service.dto.EmployeeDTO;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    private EmployeeController employeeController;

    private MockMvc mockMvc;

    @Mock
    private BindingResult bindingResult;

    private List<EmployeeDTO> employeeDTOS = Arrays.asList(new EmployeeDTO(1L,
                    "first_name", "last_name", 1L, "job_title",
                    Gender.FEMALE, new Date(25 - 02 - 2013), false),
            new EmployeeDTO(2L,
                    "first_name2", "last_name2", 2L, "job_title2",
                    Gender.FEMALE, new Date(25 - 02 - 2012), false));

    @Before
    public void init() {
        employeeController = new EmployeeController(employeeService);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
        Mockito.when(employeeService.findEmployees()).thenReturn(employeeDTOS);
    }

    @Test
    public void shouldReturnEmployeePageForStartApplicationVoid() {
        Model model = new ExtendedModelMap();
        Model addModel = new ExtendedModelMap();
        String employee = employeeController.showEmployee(model, addModel);
        Assert.assertEquals("employee", employee);
    }

    @Test
    public void requestForItemsIsSuccessfullyProcessedWithAvailableEmployeeList() throws Exception {
        this.mockMvc.perform(get("/employee.html"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("employees", equalTo(employeeDTOS)))
                .andExpect(forwardedUrl("employee"));
    }
}
