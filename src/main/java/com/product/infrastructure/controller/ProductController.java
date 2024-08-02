package com.product.infrastructure.controller;

import com.product.domain.model.Product;
import com.product.infrastructure.gateway.DeleteProductInterface;
import com.product.infrastructure.gateway.GetProductInterface;
import com.product.infrastructure.gateway.SaveProductInterface;
import com.product.infrastructure.gateway.UpdateProductInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final SaveProductInterface saveProduct;
    private final GetProductInterface getProduct;
    private final UpdateProductInterface updateProduct;
    private final DeleteProductInterface deleteProduct;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping()
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product body = saveProduct.saveProduct(product);
        return new ResponseEntity<>(body,OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> body = getProduct.getAllProducts();
        return new ResponseEntity<>(body,OK);

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductByID(@PathVariable Long id) {
        try {
            Product product = getProduct.getProduct(id);
            return new ResponseEntity<>(product, OK);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping()
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){

        try{
            Product update = updateProduct.updateProduct(product);
            return new ResponseEntity<>(update, OK);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        try{
        deleteProduct.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
        catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
