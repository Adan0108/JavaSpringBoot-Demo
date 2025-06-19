package com.adan108.repository.impl;

import com.adan108.entity.ProductEntity;
import com.adan108.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ProductEntity createProduct(ProductEntity product) {
        // Persist the ProductEntity (and, because orders are already saved and
        // this is the owning side of the @ManyToMany, JPA will insert the join rows)
        entityManager.persist(product);
        return product;
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        // Fetch all products (with their orders eager-loaded)
        return entityManager
                .createQuery("SELECT p FROM ProductEntity p", ProductEntity.class)
                .getResultList();
    }
}
