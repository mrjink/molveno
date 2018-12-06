package com.molvenolakeresort.models.restaurant.order;

import javax.persistence.*;

@Entity(name = "RestaurantInvoice")
@Table(name = "restaurant_invoice")
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
