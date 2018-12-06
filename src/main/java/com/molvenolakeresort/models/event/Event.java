package com.molvenolakeresort.models.event;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;


@Entity
public class Event {
    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String address;
    @OneToMany
    private List<User> users;
    private int maxUsers;
    private long price;
    private boolean catering;
    private String location;

    //Hashmap for the language and the eventname
    HashMap<String, String> eventnameCollection = new HashMap<String, String>();

    //Hashmap for the language and the activity
    HashMap<String, String> activityCollection = new HashMap<String, String>();

    //Hashmap for the language and the eventInformation
    HashMap<String, String> eventinformationCollection = new HashMap<String, String>();

    public Event() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HashMap<String, String> getEventnameCollection() {
        return eventnameCollection;
    }

    public void setEventnameCollection(HashMap<String, String> eventnameCollection) {
        this.eventnameCollection = eventnameCollection;
    }

    public HashMap<String, String> getActivityCollection() {
        return activityCollection;
    }

    public void setActivityCollection(HashMap<String, String> activityCollection) {
        this.activityCollection = activityCollection;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HashMap<String, String> getEventinformationCollection() {
        return eventinformationCollection;
    }

    public void setEventinformationCollection(HashMap<String, String> eventinformationCollection) {
        this.eventinformationCollection = eventinformationCollection;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean isCatering() {
        return catering;
    }

    public void setCatering(boolean catering) {
        this.catering = catering;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
