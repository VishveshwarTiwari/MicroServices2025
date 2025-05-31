package com.microservices_gpt.department_service.feign;

import com.microservices_gpt.department_service.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "employee-service")
public interface EmployeeClient {

    /*
    @GetMapping("/employees/department/{departmentId}")
    List<Employee> getEmployeesByDepartmentId(@PathVariable("departmentId") Long departmentId);
*/

    @GetMapping("/employees/department/{departmentId}")
    List<Employee> getEmployeesByDepartment( @PathVariable("departmentId") Long departmentId);
}

//💡 This matches spring.application.name in employee-service
//🔥 This is where we define the HTTP call. At runtime, Feign will automatically implement this interface for you!
// get the method signature in employee-service where we are calling --> employeeService.getEmployeesByDepartmentId(departmentId);