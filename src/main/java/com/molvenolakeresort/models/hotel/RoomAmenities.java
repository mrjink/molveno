package com.molvenolakeresort.models.hotel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RoomAmenities {

    @Id
    @GeneratedValue
    private long id;
    private String roomType;
    private String balcony;
    private String television;
    private String bath;
    private int singleSizeBeds;
    private int kingSizeBeds;
    private int queenSizeBeds;

    public RoomAmenities() {
    }

    public long getId() {
        return id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getBalcony() {
        return balcony;
    }

    public void setBalcony(String balcony) {
        this.balcony = balcony;
    }

    public String getTelevision() {
        return television;
    }

    public void setTelevision(String television) {
        this.television = television;
    }

    public String getBath() {
        return bath;
    }

    public void setBath(String bath) {
        this.bath = bath;
    }

    public int getSingleSizeBeds() {
        return singleSizeBeds;
    }

    public void setSingleSizeBeds(int singleSizeBeds) {
        this.singleSizeBeds = singleSizeBeds;
    }

    public int getKingSizeBeds() {
        return kingSizeBeds;
    }

    public void setKingSizeBeds(int kingSizeBeds) {
        this.kingSizeBeds = kingSizeBeds;
    }

    public int getQueenSizeBeds() {
        return queenSizeBeds;
    }

    public void setQueenSizeBeds(int queenSizeBeds) {
        this.queenSizeBeds = queenSizeBeds;
    }
}
