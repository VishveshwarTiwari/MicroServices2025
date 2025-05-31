package com.microservices_gpt.department_service.service;
import com.microservices_gpt.department_service.dto.DepartmentResponseDTO;
import com.microservices_gpt.department_service.entity.Department;
import com.microservices_gpt.department_service.feign.EmployeeClient;
import com.microservices_gpt.department_service.model.Employee;
import com.microservices_gpt.department_service.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;      // ✅ Feign client Injected here

    // Save a new department
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Get department by ID
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    /*
    // uses employeeClient method  getEmployeesByDepartmentId
    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        return employeeClient.getEmployeesByDepartmentId(departmentId); // ✅ Actual Feign call
    }*/

    // Get all departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Delete department by ID
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    // ✅ Actual Feign call
    public DepartmentResponseDTO getDepartmentWithEmployees(Long departmentId) {


            // Get department details from DB
            Department department = departmentRepository.findById(departmentId)
                    .orElseThrow(() -> new IllegalArgumentException("Department not found with ID: " + departmentId));

            // Get list of employees from Employee-Service using Feign client
            List<Employee> employees = employeeClient.getEmployeesByDepartment(departmentId);

            // Return the DTO
            return new DepartmentResponseDTO(department, employees);




    }
}