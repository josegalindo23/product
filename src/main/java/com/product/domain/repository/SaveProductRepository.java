package com.product.domain.repository;

import com.product.domain.model.Product;

public interface SaveProductRepository {

    Product saveProduct(Product product);
}
