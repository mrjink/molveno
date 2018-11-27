package com.molvenolakeresort.restaurant.order;

import com.molvenolakeresort.restaurant.temp.User;

import java.sql.Date;
import java.sql.Time;

public class Invoice {
    private int id;
    private User user;
    private Order order;

    private Date dateCreated;
    private Time timeCreated;


}
