package com.molvenolakeresort.models.restaurant.order;

import com.molvenolakeresort.models.restaurant.temp.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;

@Entity
public class RestaurantInvoice {
    @Id
    private Long id;

    //@???
    private Order order;

    private double price;

    public RestaurantInvoice() {

    }

}
