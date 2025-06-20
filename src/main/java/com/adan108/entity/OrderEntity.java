package com.adan108.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "java_order_001")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int userId;

    @ManyToMany(mappedBy = "orderList")
    @ToString.Exclude
    private List<ProductEntity> productList;
}
