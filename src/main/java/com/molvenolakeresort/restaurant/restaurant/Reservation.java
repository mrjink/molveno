package com.molvenolakeresort.restaurant.restaurant;

import com.molvenolakeresort.restaurant.enums.Course;
import com.molvenolakeresort.restaurant.temp.User;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
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
