package com.product.infrastructure.repository;

import com.product.domain.model.Product;
import com.product.domain.repository.UpdateProductRepository;
import com.product.infrastructure.jpa.ProductJpa;
import org.springframework.stereotype.Repository;

import static com.product.infrastructure.entitys.ProductEntity.fromModel;

@Repository
public class UpdateProductImpl implements UpdateProductRepository {

    private final ProductJpa productJpa;

    public UpdateProductImpl(ProductJpa productJpa) {
        this.productJpa = productJpa;
    }

    @Override
    public Product updateProduct(Product product) {
        return productJpa.save(fromModel(product)).toModel();
    }
}
