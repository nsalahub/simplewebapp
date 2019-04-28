package com.gmail.salahub.nikolay.simplewebapp.dao.mapper;

import com.gmail.salahub.nikolay.simplewebapp.dao.model.Employee;
import com.gmail.salahub.nikolay.simplewebapp.dao.model.Gender;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeId(resultSet.getLong("employee_id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setDepartmentId(resultSet.getLong("department_id"));
        employee.setJobTitle(resultSet.getString("job_title"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setDeleted(Boolean.valueOf(resultSet.getBoolean("deleted")));
        employee.setGender(Gender.valueOf(resultSet.getString("gender").toUpperCase()));
        employee.setDateOfBirth(resultSet.getDate("date_of_birdth"));
        return employee;
    }
}
