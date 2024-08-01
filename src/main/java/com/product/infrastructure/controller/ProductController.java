package com.product.infrastructure.controller;

import com.product.domain.model.Product;
import com.product.infrastructure.gateway.GetProductInterface;
import com.product.infrastructure.gateway.SaveProductInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final SaveProductInterface saveProduct;
    private final GetProductInterface getProduct;


    @PostMapping()
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product body = saveProduct.saveProduct(product);
        return new ResponseEntity<>(body,OK);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> body = getProduct.getAllProducts();
        return new ResponseEntity<>(body,OK);

    }
}
