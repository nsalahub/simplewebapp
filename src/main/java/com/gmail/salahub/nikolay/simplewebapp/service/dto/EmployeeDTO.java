package com.gmail.salahub.nikolay.simplewebapp.service.dto;

import com.gmail.salahub.nikolay.simplewebapp.dao.model.Gender;

import javax.validation.constraints.NotNull;
import java.sql.Date;

public class EmployeeDTO {

    private Long employeeId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Long departmentId;
    @NotNull
    private String jobTitle;
    @NotNull
    private Gender gender;
    @NotNull
    private Date dateOfBirth;
    @NotNull
    private Boolean deleted;

    public EmployeeDTO(){

    }

    public EmployeeDTO(Long employeeId,
                       String firstName,
                       String lastName,
                       Long departmentId,
                       String jobTitle,
                       Gender gender,
                       Date dateOfBirth,
                       Boolean deleted) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.jobTitle = jobTitle;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.deleted = deleted;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
