package com.product.infrastructure.gateway;

import com.product.domain.model.Product;

import java.util.List;

public interface GetProductInterface {

    Product getProduct (Long idProduct);
    List<Product> getAllProducts();
}
