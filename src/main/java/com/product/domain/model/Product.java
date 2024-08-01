package com.product.domain.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private String name;
    private BigDecimal price;
    private String description;
    private Boolean isActive;
    private Double iva;

}
