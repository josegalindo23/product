package com.product.domain.useCase;

import com.product.domain.model.Product;
import com.product.domain.repository.UpdateProductRepository;
import com.product.infrastructure.gateway.UpdateProductInterface;
import org.springframework.stereotype.Service;

@Service
public class UpdateProduct implements UpdateProductInterface {

    private final UpdateProductRepository repository;

    public UpdateProduct(UpdateProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public Product updateProduct(Product product) {
        return repository.updateProduct(product);
    }
}
