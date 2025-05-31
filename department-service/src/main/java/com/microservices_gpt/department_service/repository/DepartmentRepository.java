package com.microservices_gpt.department_service.repository;
import com.microservices_gpt.department_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // No need to write methods now, JpaRepository provides standard CRUD
}