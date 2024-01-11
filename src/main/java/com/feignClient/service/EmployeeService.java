package com.feignClient.service;

import com.feignClient.employeRepository.EmployeeRepository;
import com.feignClient.entity.Employee;
import com.feignClient.feignClient.AddressClient;
import com.feignClient.response.AddressResponse;
import com.feignClient.response.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper mapper;

    // Spring will create the implementation
    // for this class
    // and will inject the bean here (proxy)
    @Autowired
    private AddressClient addressClient;

    public EmployeeResponse getEmployeeById(int empId) {

        Optional<Employee> employee = employeeRepository.findByEmpId(empId);
        EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);

        // Using FeignClient
        ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(empId);
        employeeResponse.setAddressResponse(addressResponse.getBody());

        return employeeResponse;
    }


}

