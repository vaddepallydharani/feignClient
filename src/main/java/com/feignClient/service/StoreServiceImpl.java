package com.feignClient.service;

import com.feignClient.employeRepository.StoreRepository;
import com.feignClient.entity.StoreEntity;
import com.feignClient.feignClient.AddressClient;
import com.feignClient.response.AddressResponse;
import com.feignClient.response.StoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private AddressClient addressClient;


    @Override
    public StoreEntity saveStoreDetails(StoreEntity store) {
        return storeRepository.save(store);
    }

    public StoreResponse getStore(Integer storeId){
        Optional<StoreEntity> storeEntityOptional= storeRepository.findById(storeId);
       //AddressResponse addressResponse= restTemplate.exchange("http://localhost:8081/basic-app/address-service/address/"+storeId , HttpMethod.GET,null, AddressResponse.class).getBody();
        ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(storeId);
       StoreResponse storeResponse=new StoreResponse();
       if(!storeEntityOptional.isEmpty()){
           storeResponse.setStoreId(storeEntityOptional.get().getStoreId());
           storeResponse.setStoreName(storeEntityOptional.get().getStoreName());
       }

       storeResponse.setAddressResponse(addressResponse.getBody());
        return storeResponse;
    }

    @Override
    public List<StoreResponse> getStores() {
        List<StoreEntity> storeEntities = storeRepository.findAll();

        List<StoreResponse> storeResponses = new ArrayList<>();

        for (StoreEntity storeEntity : storeEntities) {
            StoreResponse storeResponse = new StoreResponse();
            storeResponse.setStoreId(storeEntity.getStoreId());
            storeResponse.setStoreName(storeEntity.getStoreName());
            ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(storeEntity.getStoreId());
            storeResponse.setAddressResponse(addressResponse.getBody());

            storeResponses.add(storeResponse);

        }
        return storeResponses;
    }

}
