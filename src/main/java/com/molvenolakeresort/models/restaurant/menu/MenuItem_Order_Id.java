package com.molvenolakeresort.models.restaurant.menu;

import java.io.Serializable;

public class MenuItem_Order_Id implements Serializable {

    private Long idMenuItem;
    private Long idOrder;

    private MenuItem_Order_Id() {
    }

    public MenuItem_Order_Id(Long idMenuItem, Long idOrder) {
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
