package com.microservices_gpt.department_service.model;


public class Employee {

    private Long employeeId;

    private String employeeName;

    private String employeeEmail;

    private Long departmentId;  // foreign key reference (logical) to Department

    // Constructors
    public Employee() {}

    public Employee(Long employeeId, String employeeName, String employeeEmail, Long departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.departmentId = departmentId;
    }

    // Getters and setters

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}