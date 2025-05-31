package com.microservices_gpt.department_service.controller;

import com.microservices_gpt.department_service.dto.DepartmentResponseDTO;
import com.microservices_gpt.department_service.entity.Department;
import com.microservices_gpt.department_service.feign.EmployeeClient;
import com.microservices_gpt.department_service.model.Employee;
import com.microservices_gpt.department_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;



    // Create new department
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    // Get department by ID
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Optional<Department> department = departmentService.getDepartmentById(id);
        if (department.isPresent()) {
            return ResponseEntity.ok(department.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*
    //feign call
    @GetMapping("/{departmentId}/employees")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok(departmentService.getEmployeesByDepartment(departmentId));
    }*/

    //feign call @GetMapping("/{departmentId}/employees/details")

    //feign call
    @GetMapping("/{departmentId}/employees")
    public ResponseEntity<DepartmentResponseDTO> getDepartmentWithEmployees(@PathVariable Long departmentId) {
        DepartmentResponseDTO response = departmentService.getDepartmentWithEmployees(departmentId);
        return ResponseEntity.ok(response);
    }



    // Get all departments
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    // Delete department by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartmentById(@PathVariable Long id) {
        departmentService.deleteDepartmentById(id);
        return ResponseEntity.noContent().build();
    }
}