package com.molvenolakeresort.restaurant.restaurant;

import com.molvenolakeresort.restaurant.enums.Course;
import com.molvenolakeresort.restaurant.temp.User;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
import java.sql.Time;
import java.sql.Date;
//import lombok.Data;
//import javax.persistence.Entity;

//@Data
//@Entity
public class Reservation {
//    private @Id @GeneratedValue long id;
    private final User user;
    private final Date date;
    private final Time time;
    private final Course course;

    public Reservation(User user, Date date, Time time, Course course) {
        this.user = user;
        this.date = date;
        this.time = time;
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public Course getCourse() {
        return course;
    }
}
