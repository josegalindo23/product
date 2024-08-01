package com.product.domain.useCase;

import com.product.domain.model.Product;
import com.product.domain.repository.GetProductRepository;
import com.product.infrastructure.gateway.GetProductInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProduct implements GetProductInterface {
    private final GetProductRepository repository;

    public GetProduct(GetProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product getProduct(Long idProduct) {
        return repository.getProduct(idProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.getAllProducts();
    }
}
