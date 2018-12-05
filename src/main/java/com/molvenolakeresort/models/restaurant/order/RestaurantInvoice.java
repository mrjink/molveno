package com.molvenolakeresort.models.restaurant.order;

import com.molvenolakeresort.models.restaurant.temp.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;

@Entity
public class RestaurantInvoice {
    @Id @GeneratedValue
    private Long idRestaurantInvoice;

    //@???
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
