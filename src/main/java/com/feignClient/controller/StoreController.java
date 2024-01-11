package com.feignClient.controller;

import com.feignClient.entity.StoreEntity;
import com.feignClient.response.StoreResponse;
import com.feignClient.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storeService")
public class StoreController {
    @Autowired
    StoreService storeService;

    @PostMapping("/save")
    public StoreEntity saveStoreDetails(@RequestBody StoreEntity store){
        return storeService.saveStoreDetails(store);
    }

    @GetMapping("/store")
    public StoreResponse getStore(@RequestParam Integer storeId){
        return storeService.getStore(storeId);
    }

    @GetMapping("/stores")
    public List<StoreResponse> getAllStore(){
       return storeService.getStores();

    }
}
