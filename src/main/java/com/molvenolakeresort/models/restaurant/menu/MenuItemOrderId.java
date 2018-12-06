package com.molvenolakeresort.models.restaurant.menu;

import javax.persistence.Column;
import java.io.Serializable;

public class MenuItemOrderId implements Serializable {
    @Column(name = "menu_item_id")
    private Long idMenuItem;

    @Column(name = "order_id")
    private Long idOrder;

    private MenuItemOrderId() {
    }

    public MenuItemOrderId(Long idMenuItem, Long idOrder) {
        this.idMenuItem = idMenuItem;
        this.idOrder = idOrder;
    }

    public Long getIdMenuItem() {
        return idMenuItem;
    }

    public Long getIdOrder() {
        return idOrder;
    }
}
