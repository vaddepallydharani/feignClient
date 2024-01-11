package com.feignClient.response;

import lombok.Data;
@Data
public class AddressResponse {

        private Integer addressId;
        private String street;
        private String city;
        private String state;
        private String country;
        private String zipcode;


}
