package com.molvenolakeresort.mappers.hotel;

import com.molvenolakeresort.models.hotel.Guest;
import com.molvenolakeresort.models.hotel.Reservation;
import com.molvenolakeresort.models.hotel.ReservationGuest;
import com.molvenolakeresort.models.hotel.Room;
import com.molvenolakeresort.views.hotel.GuestInformationView;

import java.util.Iterator;
import java.util.Set;

public class GuestMapper {
    public static GuestInformationView mapGuestToGuestInformationView(Guest guest) {
        GuestInformationView view = new GuestInformationView();
        view.setAddress(guest.getAddress());
        view.setDateOfBirth(guest.getDateOfBirth());
        view.setFirstName(guest.getFirstName());
        view.setLastName(guest.getLastName());
        view.setPhoneNumber(guest.getPhoneNumber());
        view.setEmail(guest.getEmail());
        view.setNewsletterSubscribed(guest.isNewsletterSubscribed());

        for (ReservationGuest reservationGuest : guest.getReservationGuests()) {
            Reservation reservation = reservationGuest.getReservation();
            if (reservation.isReservationValid()) {
                view.setStartDate(reservation.getStartDate());
                view.setEndDate(reservation.getEndDate());
                view.setCheckedIn(reservation.isCheckedIn());
                Set<Room> rooms = reservation.getRooms();
                StringBuilder roomNumbers = new StringBuilder();
                for (int i = 0; i < rooms.size(); i++) {
                    Iterator<Room> iterator = rooms.iterator();
                    roomNumbers.append(iterator.next().getRoomNumber());
                    if (iterator.hasNext()) {
                        roomNumbers.append(", ");
                    }
                }
                view.setRoomNumber(roomNumbers.toString());
            }
        }
        return view;
    }
}
