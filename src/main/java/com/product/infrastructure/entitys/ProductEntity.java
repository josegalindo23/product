package com.product.infrastructure.entitys;

import com.product.domain.model.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private boolean isActive;
    private double iva;

    public Product toModel(){
        return Product.builder()
                .name(this.name)
                .price(this.price)
                .description(this.description)
                .isActive(this.isActive)
                .iva(this.iva)
                .build();
    }


    public static ProductEntity fromModel(Product product){
        return ProductEntity.builder()
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .isActive(product.getIsActive())
                .iva(product.getIva())
                .build();

    }
}
