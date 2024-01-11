package com.feignClient.feignClient;

import com.feignClient.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "address-service", url = "http://localhost:8081", path = "/basic-app/address-service")
public interface AddressClient {

    @GetMapping("/address/{addressId}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("addressId") int empId);
}
