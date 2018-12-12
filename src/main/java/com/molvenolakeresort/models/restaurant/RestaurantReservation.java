package com.molvenolakeresort.models.restaurant;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.molvenolakeresort.models.hotel.Guest;
import com.molvenolakeresort.models.restaurant.enums.Course;
import com.molvenolakeresort.models.restaurant.temp.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name = "RestaurantReservation")
@Table(name = "restaurant_reservation")
public class RestaurantReservation {

    private @Id
    @GeneratedValue
    Long idRestaurantReservation;
    private Integer amountOfPeople;
    @OneToOne(cascade = CascadeType.ALL)
    private Guest guest;
    private LocalDate date;
    private LocalTime time;
    private Course course;

    @OneToMany
    private List<RestaurantTable> restaurantTables;

    public RestaurantReservation() {
    }


    public Guest getGuest() {
        return guest;
    }
/*
    public List<RestaurantTable> getTables() {
        return restaurantTables;
    }*/

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public Course getCourse() {
        return course;
    }

    public Long getId() {
        return idRestaurantReservation;
    }

    public Integer getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setIdRestaurantReservation(Long idRestaurantReservation) {
        this.idRestaurantReservation = idRestaurantReservation;
    }

    public void setAmountOfPeople(Integer amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setRestaurantTables(List<RestaurantTable> restaurantTables) {
        this.restaurantTables = restaurantTables;
    }
}
