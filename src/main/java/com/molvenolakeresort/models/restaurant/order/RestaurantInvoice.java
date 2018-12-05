package com.molvenolakeresort.models.restaurant.order;

import javax.persistence.*;

@Entity(name = "RestaurantInvoice")
public class RestaurantInvoice {
    @Id @GeneratedValue
    private Long idRestaurantInvoice;

    @OneToOne
    private Order order;

    private double price;

    public RestaurantInvoice() {

    }

    public Long getIdRestaurantInvoice() {
        return idRestaurantInvoice;
    }

    public Order getOrder() {
        return order;
    }

    public double getPrice() {
        return price;
    }
}
