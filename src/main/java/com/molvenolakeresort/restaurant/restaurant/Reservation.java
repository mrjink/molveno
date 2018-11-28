package com.molvenolakeresort.restaurant.restaurant;

import com.molvenolakeresort.restaurant.enums.Course;
import com.molvenolakeresort.restaurant.temp.User;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.sql.Date;
import java.util.List;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@Entity
public class Reservation {
    private @Id @GeneratedValue long id;

    @OneToOne
    private User user;
    private String date;
    private String time;
    private Course course;

    @OneToOne
    private Table table;

    public Reservation(User user, String date, String time, Course course) {
        this.user = user;
        this.date = date;
        this.time = time;
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public Table getTable() {
        return table;
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
