package com.product.infrastructure.repository;

import com.product.domain.repository.DeleteProductRepository;
import com.product.infrastructure.jpa.ProductJpa;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteProductImpl implements DeleteProductRepository {

    private final ProductJpa productJpa;

    public DeleteProductImpl(ProductJpa productJpa) {
        this.productJpa = productJpa;
    }

    @Override
    public void deleteProduct(Long idProduct) {
        productJpa.deleteById(idProduct);
    }
}
