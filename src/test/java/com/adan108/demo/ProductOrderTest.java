package com.adan108.demo;

import com.adan108.entity.OrderEntity;
import com.adan108.entity.ProductEntity;
import com.adan108.repository.OrderRepository;
import com.adan108.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class ProductOrderTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Transactional
    @Rollback(false)
    void manyToManyInsertTest() {
        // 1) Create and save orders first
        OrderEntity o1 = new OrderEntity();
        o1.setUserId(1);
        OrderEntity o2 = new OrderEntity();
        o2.setUserId(2);
        OrderEntity o3 = new OrderEntity();
        o3.setUserId(3);

        orderRepository.save(o1);
        orderRepository.save(o2);
        orderRepository.save(o3);

        // 2) Create products and link to orders
        ProductEntity p1 = new ProductEntity();
        p1.setProductName("p1");
        p1.setProductPrice(new BigDecimal("4.6"));
        p1.setOrderList(List.of(o1, o2));

        ProductEntity p2 = new ProductEntity();
        p2.setProductName("p2");
        p2.setProductPrice(new BigDecimal("5.6"));
        p2.setOrderList(List.of(o1, o3, o2));

        // 3) Persist via your custom method
        productRepository.createProduct(p1);
        productRepository.createProduct(p2);
    }

    @Test
    @Transactional
    void selectManyToManyTest() {
        // 1) load all products…
        List<ProductEntity> products = productRepository.findAllProducts();

        // 2) pick out the one you want (id = 1)
        ProductEntity p1 = products.stream()
                .filter(p -> p.getId().equals(1L))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Product 1 not found"));

        // 3) inspect it
        System.out.println(p1);
        System.out.println("Linked orders: " + p1.getOrderList());
    }

}
