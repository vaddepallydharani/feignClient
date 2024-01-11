package com.feignClient.response;

import lombok.Data;

@Data
public class EmployeeResponse {
    private int empId;
    private String empName;
    private int empSalary;
    private AddressResponse addressResponse;

}
