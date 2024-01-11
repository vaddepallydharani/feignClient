package com.feignClient.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="emp_id")
    private int empId;
    @Column(name="emp_name")
    private String empName;
    @Column(name="emp_salary")
    private int empSalary;
}
