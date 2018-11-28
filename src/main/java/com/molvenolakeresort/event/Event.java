package com.molvenolakeresort.event;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private long id;
    LocalDateTime startDate;
    LocalDateTime endData;
    String adress;
    //@OneToMany
    List<User> users;
    int maxParticipants;
    long price;
    boolean catering;

    //Hashmap for the language and the eventname
    HashMap<String, String> eventnameCollection = new HashMap<String, String>();

    //Hashmap for the language and the activity
    HashMap<String, String> activityCollection = new HashMap<String, String>();

    //Hashmap for the language and the eventInformation
    HashMap<String, String> eventinformationCollection = new HashMap<String, String>();

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

    public LocalDateTime getEndData() {
        return endData;
    }

    public void setEndData(LocalDateTime endData) {
        this.endData = endData;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
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
}
