package com.microservices_gpt.department_service.dto;
import com.microservices_gpt.department_service.entity.Department;
import com.microservices_gpt.department_service.model.Employee;

import java.util.List;

public class DepartmentResponseDTO {

    private Long departmentId;
    private String departmentName;
    private String departmentCode;
    private String departmentAddress;
    private List<Employee> employees;

    // No-args constructor
    public DepartmentResponseDTO() {
    }

    // All-args constructor
    public DepartmentResponseDTO(Long departmentId, String departmentName, String departmentCode,
                                 String departmentAddress, List<Employee> employees) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.departmentAddress = departmentAddress;
        this.employees = employees;
    }

    // Constructor from Department entity + employee list
    public DepartmentResponseDTO(Department department, List<Employee> employees) {
        this.departmentId = department.getDepartmentId();
        this.departmentName = department.getDepartmentName();
        this.departmentCode = department.getDepartmentCode();
        this.departmentAddress = department.getDepartmentAddress();
        this.employees = employees;
    }

    // Getters and Setters

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    // toString() for debugging

    @Override
    public String toString() {
        return "DepartmentResponseDTO{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", employees=" + employees +
                '}';
    }
}