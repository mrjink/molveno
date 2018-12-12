package com.molvenolakeresort.models.hotel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private long id;
    private String roomNumber;
    private String roomStatus;
    private String roomBlocked;
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

    public long getId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomAmenities getRoomAmenities() {
        return roomAmenities;
    }

    public void setRoomAmenities(RoomAmenities roomAmenities) {
        this.roomAmenities = roomAmenities;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomBlocked() {
        return roomBlocked;
    }

    public void setRoomBlocked(String roomBlocked) {
        this.roomBlocked = roomBlocked;
    }
}
