package com.feignClient.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "store")
@Data
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "store_id")
    private Integer storeId;

    @Column(name = "store_name")
    private String storeName;

}
