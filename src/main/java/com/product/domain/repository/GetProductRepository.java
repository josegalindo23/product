package com.product.domain.repository;

import com.product.domain.model.Product;

import java.util.List;

public interface GetProductRepository {

    Product getProduct (Long idProduct);
    List<Product> getAllProducts();
}
