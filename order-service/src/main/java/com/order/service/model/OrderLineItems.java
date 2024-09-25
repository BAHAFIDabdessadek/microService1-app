package com.order.service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "orderLineItems") // Escaping the table name using backticks
public class OrderLineItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String skuCode;
    private BigDecimal price;
    private Integer quantite;
}
