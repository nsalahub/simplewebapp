package com.gmail.salahub.nikolay.simplewebapp.dao.impl;

import com.gmail.salahub.nikolay.simplewebapp.dao.EmployeeDao;
import com.gmail.salahub.nikolay.simplewebapp.dao.mapper.EmployeeMapper;
import com.gmail.salahub.nikolay.simplewebapp.dao.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

    private Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addEmployee(Employee employee) {
        jdbcTemplate.update("INSERT INTO employee(first_name,last_name,department_id,\n" +
                        "job_title,gender,date_of_birdth,deleted) VALUES ( ?, ?, ?, ?, ?, 'false');",
                employee.getFirstName(), employee.getLastName(),
                employee.getDepartmentId(), employee.getJobTitle(), employee.getGender());
        logger.info("Employee added success!");
    }

    @Override
    public void deleteEmployeeById(Long id) {
        jdbcTemplate.update("UPDATE employee SET deleted = true WHERE id =?", id);
        logger.info("Update employee success");
    }

    @Override
    public void updateEmployee(Employee employee) {
        jdbcTemplate.update("UPDATE employee SET first_name = ?, last_name = ?, department_id = ?," +
                        "job_title=?, gender=? date_of_birdth=? WHERE id =?", employee.getFirstName(), employee.getLastName(),
                employee.getDepartmentId(), employee.getJobTitle(), employee.getGender(), employee.getDateOfBirth()
                , employee.getEmployeeId());
        logger.info("Update employee success");
    }


    @Override
    public Employee getEmployeeById(Long employeeId) {
        Employee employee = (Employee) jdbcTemplate.queryForObject("SELECT * FROM employee WHERE employee_id = ? ;",
                new Object[]{employeeId}, new EmployeeMapper());
        logger.info("Getting employee");
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = jdbcTemplate.query("SELECT * FROM employee", new EmployeeMapper());
        logger.info("Getting emplyees");
        return employees;
    }

}
