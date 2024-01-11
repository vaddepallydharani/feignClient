package com.feignClient.controller;


import com.feignClient.response.EmployeeResponse;
import com.feignClient.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{empId}")
    private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("empId") int empId) {
        EmployeeResponse employee = employeeService.getEmployeeById(empId);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @GetMapping("/employees")
    public List<EmployeeResponse> getEmployees(){
        return employeeService.getEmployeesDetails();
    }


}
