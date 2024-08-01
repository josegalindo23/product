package com.product.infrastructure.repository;

import com.product.domain.model.Product;
import com.product.domain.repository.UpdateProductRepository;
import com.product.infrastructure.entitys.ProductEntity;
import com.product.infrastructure.jpa.ProductJpa;
import org.springframework.stereotype.Repository;


@Repository
public class UpdateProductImpl implements UpdateProductRepository {

    private final ProductJpa productJpa;

    public UpdateProductImpl(ProductJpa productJpa) {
        this.productJpa = productJpa;
    }

    @Override
    public Product updateProduct(Product product) {
        ProductEntity existingProduct = productJpa.findById(product.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setActive(product.getIsActive());
        existingProduct.setIva(product.getIva());
        return productJpa.save(existingProduct).toModel();
    }
}
