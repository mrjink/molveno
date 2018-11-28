package com.molvenolakeresort.restaurant.restaurant;

import com.molvenolakeresort.restaurant.enums.TableShape;
import org.apache.tomcat.jni.Library;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Table {

    @Id
    private int id;
    private TableShape shape;
    private int maxSeats;

    @ManyToOne
//    @JoinColumn(name="reservation_id")
    private Reservation reservation;

    public Table(int id, TableShape shape, int maxSeats) {
        this.id = id;
        this.shape = shape;
        this.maxSeats = maxSeats;
    }
}
