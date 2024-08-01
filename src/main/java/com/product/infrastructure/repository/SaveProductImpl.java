package com.product.infrastructure.repository;

import com.product.domain.model.Product;
import com.product.domain.repository.SaveProductRepository;
import com.product.infrastructure.jpa.ProductJpa;
import org.springframework.stereotype.Repository;

import static com.product.infrastructure.entitys.ProductEntity.fromModel;

@Repository
public class SaveProductImpl implements SaveProductRepository {

    private final ProductJpa productJpa;

    public SaveProductImpl(ProductJpa productJpa) {
        this.productJpa = productJpa;
    }

    @Override
    public Product saveProduct(Product product) {
        return productJpa.save(fromModel(product)).toModel();
    }
}
