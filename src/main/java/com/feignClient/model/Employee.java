package com.feignClient.model;

import lombok.Data;

@Data
public class Employee {

    private int empId;
    private String empName;
    private int empSalary;
    private  int addressId;
}
