package com.molvenolakeresort.views.hotel;

import java.io.Serializable;
import java.time.LocalDateTime;

public class RoomInformationView implements Serializable {
    private String roomNumber;
    private String roomStatus;
    private String roomBlocked;
    private int numberOfBeds;
    private String lastName;
    private String firstName;
    private String country;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
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
