package com.feignClient.employeRepository;

import com.feignClient.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<StoreEntity,Integer> {
}
