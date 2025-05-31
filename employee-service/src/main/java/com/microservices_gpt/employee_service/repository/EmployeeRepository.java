package com.microservices_gpt.employee_service.repository;

import com.microservices_gpt.employee_service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Custom finder by departmentId
    List<Employee> findByDepartmentId(Long departmentId);
}