package com.molvenolakeresort.models.restaurant.order;

import com.molvenolakeresort.models.hotel.Room;
import com.molvenolakeresort.models.restaurant.RestaurantTable;
import com.molvenolakeresort.models.restaurant.enums.SupplierOrderStatus;
import com.molvenolakeresort.models.restaurant.menu.MenuItemOrder;

import javax.persistence.*;
import java.util.List;

@Entity (name = "RestaurantOrder")
@Table(name = "restaurant_order")
public class Order {

    @Id @GeneratedValue
    private Long idOrder;
    private SupplierOrderStatus status;
    private int totalPrice;

    @ManyToOne
    private Room room;
    @OneToOne
    private RestaurantTable restaurantTable;

    //EVENT????

    @OneToMany(
        mappedBy = "order",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<MenuItemOrder> menuItem_orders;

    public Long getIdOrder() {
        return idOrder;
    }

    public SupplierOrderStatus getStatus() {
        return status;
    }
}
