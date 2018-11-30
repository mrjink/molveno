package com.molvenolakeresort.models.restaurant.order;

import com.molvenolakeresort.models.restaurant.temp.User;

import java.sql.Date;
import java.sql.Time;

public class Invoice {
    private int id;
    private User user;
    private Order order;

    private Date dateCreated;
    private Time timeCreated;


}
