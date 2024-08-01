package com.product.domain.useCase;

import com.product.domain.repository.DeleteProductRepository;
import com.product.infrastructure.gateway.DeleteProductInterface;
import org.springframework.stereotype.Service;

@Service
public class DeleteProduct implements DeleteProductInterface {

    private final DeleteProductRepository repository;


    public DeleteProduct(DeleteProductRepository repository) {
        this.repository = repository;

    }

    @Override
    public void deleteProduct(Long idProduct) {
        repository.deleteProduct(idProduct);
    }
}
