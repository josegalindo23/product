package com.product.infrastructure.repository;

import com.product.domain.model.Product;
import com.product.domain.repository.GetProductRepository;
import com.product.infrastructure.entitys.ProductEntity;
import com.product.infrastructure.jpa.ProductJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GetProductImpl implements GetProductRepository {

    private final ProductJpa productJpa;

    public GetProductImpl(ProductJpa productJpa) {
        this.productJpa = productJpa;
    }

    @Override
    public Product getProduct(Long idProduct) {
        return productJpa.findById(idProduct).get().toModel();
    }

    @Override
    public List<Product> getAllProducts() {

        List<ProductEntity> getCasasd = productJpa.findAll();
        return productJpa.findAll()
                .stream().map(ProductEntity::toModel)
                .collect(Collectors.toList());
    }
}
