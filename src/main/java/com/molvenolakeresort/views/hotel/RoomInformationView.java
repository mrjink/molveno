package com.molvenolakeresort.views.hotel;

import com.molvenolakeresort.models.hotel.Guest;
import com.molvenolakeresort.models.hotel.RoomAmenities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class RoomInformationView implements Serializable {
    private String roomNumber;
    private String roomStatus;
    private String roomBlocked;
    private int numberOfBeds;
    private Guest mainBooker;
    private List<Guest> otherGuests;
    private RoomAmenities roomAmenities;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean checkedIn;


    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomBlocked(String roomBlocked) {
        this.roomBlocked = roomBlocked;
    }

    public String getRoomBlocked() {
        return roomBlocked;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public Guest getMainBooker() {
        return mainBooker;
    }

    public void setMainBooker(Guest mainBooker) {
        this.mainBooker = mainBooker;
    }

    public List<Guest> getOtherGuests() {
        return otherGuests;
    }

    public void setOtherGuests(List<Guest> otherGuests) {
        this.otherGuests = otherGuests;
    }

    public RoomAmenities getRoomAmenities() {
        return roomAmenities;
    }

    public void setRoomAmenities(RoomAmenities roomAmenities) {
        this.roomAmenities = roomAmenities;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }
}
