package com.molvenolakeresort.mappers.hotel;

import com.molvenolakeresort.models.hotel.Guest;
import com.molvenolakeresort.models.hotel.Reservation;
import com.molvenolakeresort.models.hotel.ReservationGuest;
import com.molvenolakeresort.models.hotel.Room;
import com.molvenolakeresort.views.hotel.PendingReservationInformationView;

import java.util.Iterator;
import java.util.Set;

public class PendingReservationMapper {
    public static PendingReservationInformationView mapReservationToPendingReservationInformationView(Reservation reservation) {
        PendingReservationInformationView view = new PendingReservationInformationView();

        view.setId(reservation.getId());
        view.setApproved(false);
        view.setNrAdults(reservation.getNrAdults());
        view.setNrChildren(reservation.getNrChildren());
        view.setPet(reservation.getPet().name());
        view.setRemarks(reservation.getRemarks());
        view.setStartDate(reservation.getStartDate());
        view.setEndDate(reservation.getEndDate());

        Set<Room> rooms = reservation.getRooms();

        StringBuilder roomTypes = new StringBuilder();
        for (int i = 0; i < rooms.size(); i++) {
            Iterator<Room> iterator = rooms.iterator();
            roomTypes.append(iterator.next().getRoomAmenities().getRoomType());
            if (iterator.hasNext()) {
                roomTypes.append(", ");
            }
        }
        view.setRoomTypes(roomTypes.toString());

        for (ReservationGuest reservationGuest : reservation.getReservationGuests()) {
            if (reservationGuest.isMainBooker()) {
                Guest guest = reservationGuest.getGuest();
                view.setFirstName(guest.getFirstName());
                view.setLastName(guest.getLastName());
                view.setEmail(guest.getEmail());
            }
        }
        return view;
    }
}
