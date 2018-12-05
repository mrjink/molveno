package com.molvenolakeresort.controllers.hotel;

import com.molvenolakeresort.models.hotel.*;
import com.molvenolakeresort.repositories.hotel.RoomRepository;
import com.molvenolakeresort.views.hotel.RoomInformationView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/rooms/")
public class RoomController {


    private RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<RoomInformationView> getAll() {

        List<RoomInformationView> result = new ArrayList<>();
        for (Room room : this.roomRepository.findAll()) {
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
            result.add(view);
        }
        return result;
    }
}
