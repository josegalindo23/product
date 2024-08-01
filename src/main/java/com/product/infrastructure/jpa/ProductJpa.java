package com.product.infrastructure.jpa;

import com.product.infrastructure.entitys.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpa extends JpaRepository<ProductEntity,Long> {
}
