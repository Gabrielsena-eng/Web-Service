package com.GabrielsSena.Web.Service.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orderItem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString

public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    //Atribuindo o preço da tabela, ao subtotal do orderItem
    public OrderItem(Double price){
        this.price = subTotal(product, quantity);
    }

    //Calculo de subtotal por produto;
    public Double subTotal(Product product, Integer quantity ){

        return product.getPrice() * quantity;
    }

    public OrderItem(Long id, Integer quantity, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
    }
}
