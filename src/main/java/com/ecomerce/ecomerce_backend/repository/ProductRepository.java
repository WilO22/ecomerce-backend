package com.ecomerce.ecomerce_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ecomerce.ecomerce_backend.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
