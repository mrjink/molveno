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
    private double totalPrice;

    //@OneToMany
    //private List<Room> room;
    //@OneToOne
    //private Event event;
    @OneToOne(cascade = CascadeType.REMOVE)
    private RestaurantTable restaurantTable;

    //EVENT????
    @ManyToMany(
        //mappedBy = "order",
        cascade = CascadeType.REMOVE
    )
    private List<MenuItemOrder> menuItem_orders;

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public SupplierOrderStatus getStatus() {
        return status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(SupplierOrderStatus status) {
        this.status = status;
    }

    public List<MenuItemOrder> getMenuItem_orders() {
        return menuItem_orders;
    }

    public void setMenuItem_orders(List<MenuItemOrder> menuItem_orders) {
        this.menuItem_orders = menuItem_orders;
    }

    public RestaurantTable getRestaurantTable() {
        return restaurantTable;
    }

    public void setRestaurantTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }
}
