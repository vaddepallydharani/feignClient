package com.feignClient.response;

import lombok.Data;

@Data
public class StoreResponse {
    private Integer storeId;
    private String storeName;
    private  AddressResponse addressResponse;


}
