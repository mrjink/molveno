package com.molvenolakeresort.models.restaurant.order;

import com.molvenolakeresort.models.hotel.Room;
import com.molvenolakeresort.models.restaurant.RestaurantTable;
import com.molvenolakeresort.models.restaurant.enums.DestinationType;
import com.molvenolakeresort.models.restaurant.enums.SupplierOrderStatus;
import com.molvenolakeresort.models.restaurant.menu.MenuItem_Order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Order {

    @Id @GeneratedValue
    private Long idOrder;
    private SupplierOrderStatus status;
    private int totalPrice;

    //@??
    private Room room;
    //@??
    private RestaurantTable restaurantTable;

    //EVENT????

    @OneToMany
    private MenuItem_Order menuItem_order;

    public Long getIdOrder() {
        return idOrder;
    }

    public SupplierOrderStatus getStatus() {
        return status;
    }
}
