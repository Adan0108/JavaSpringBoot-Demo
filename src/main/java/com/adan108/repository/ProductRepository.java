package com.adan108.repository;

import com.adan108.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository {

    ProductEntity createProduct(ProductEntity product);

    List<ProductEntity> findAllProducts();
}
