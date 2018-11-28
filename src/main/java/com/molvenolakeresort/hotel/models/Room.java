package com.molvenolakeresort.hotel.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private int id;
    private String roomNumber;
    @ManyToOne
    @JoinColumn
    private RoomAmenities roomAmenities;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "ReservationRoom",
            joinColumns = { @JoinColumn },
            inverseJoinColumns = { @JoinColumn })
    private Set<Reservation> reservations = new HashSet<>();

    public Room() {
    }

    public int getId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
