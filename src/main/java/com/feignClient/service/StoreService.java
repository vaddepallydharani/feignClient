package com.feignClient.service;

import com.feignClient.entity.StoreEntity;
import com.feignClient.response.StoreResponse;

import java.util.List;

public interface StoreService {

    public StoreEntity saveStoreDetails(StoreEntity store);
    public StoreResponse getStore(Integer storeId);

    List<StoreResponse> getStores();
}
