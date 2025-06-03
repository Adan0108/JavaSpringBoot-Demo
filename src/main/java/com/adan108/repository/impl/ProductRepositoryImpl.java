package com.adan108.repository.impl;

import com.adan108.entity.ProductEntity;
import com.adan108.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public ProductEntity createProduct(ProductEntity product){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setProductName("Adan108 Create");
        productEntity.setProductPrice(new BigDecimal("21.8"));

        return productEntity;
    }

    @Override
    public List<ProductEntity> findAllProducts(){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setProductName("Adan108");
        productEntity.setProductPrice(new BigDecimal("21.8"));
        return List.of(productEntity);
    }
}
