package com.molvenolakeresort.models.kitchen.restaurant;

import com.molvenolakeresort.models.kitchen.enums.Course;
import com.molvenolakeresort.models.kitchen.temp.User;
import com.molvenolakeresort.models.restaurant.Table;

import javax.persistence.*;
import java.util.List;

@Entity
public class Reservation {
    private @Id @GeneratedValue long id;

    @OneToOne
    private User user;
    private String date;
    private String time;
    private Course course;

    @OneToMany(mappedBy = "reservation")
    private List<Table> tables;

    public Reservation(User user, String date, String time, Course course, List<Table> tables) {
        this.user = user;
        this.date = date;
        this.time = time;
        //deze strings omzetten naar timestamp.
        this.course = course;
        this.tables = tables;
    }

    public User getUser() {
        return user;
    }

    public List<Table> getTables() {
        return tables;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Course getCourse() {
        return course;
    }
}
