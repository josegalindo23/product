package com.product.domain.useCase;

import com.product.domain.model.Product;
import com.product.domain.repository.SaveProductRepository;
import com.product.infrastructure.gateway.SaveProductInterface;
import org.springframework.stereotype.Service;


@Service
public class SaveProduct implements SaveProductInterface {

    private final SaveProductRepository repository;

    public SaveProduct(SaveProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product saveProduct(Product product) {
        return repository.saveProduct(product);
    }
}
