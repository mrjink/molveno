package com.molvenolakeresort.mappers.hotel;

import com.molvenolakeresort.models.hotel.*;
import com.molvenolakeresort.views.hotel.RoomInformationView;

import java.util.ArrayList;
import java.util.List;

public class RoomMapper {
    public static RoomInformationView mapRoomToRoomInformationView(Room room) {
        RoomAmenities roomAmenities = room.getRoomAmenities();

        RoomInformationView view = new RoomInformationView();
        List<Guest> otherGuestsList = new ArrayList<>();

        view.setRoomNumber(room.getRoomNumber());
        view.setRoomStatus(room.getRoomStatus());
        view.setRoomBlocked(room.getRoomBlocked());
        view.setRoomAmenities(roomAmenities);
        view.setNumberOfBeds(roomAmenities.getKingSizeBeds() +
                roomAmenities.getQueenSizeBeds() +
                roomAmenities.getSingleSizeBeds());

        for (Reservation reservation : room.getReservations()) {
            if (reservation.isReservationValid()) {
                for (ReservationGuest reservationGuest : reservation.getReservationGuests()) {
                    if (reservationGuest.isMainBooker()) {
                        view.setMainBooker(reservationGuest.getGuest());
                    } else {
                        otherGuestsList.add(reservationGuest.getGuest());
                    }
                }
                view.setPet(reservation.getPet());
                view.setBookedBy(reservation.getBookedBy());
                view.setStartDate(reservation.getStartDate());
                view.setEndDate(reservation.getEndDate());
                view.setCheckedIn(reservation.isCheckedIn());
                break;
            }
        }
        view.setOtherGuests(otherGuestsList);
        return view;
    }
}
