package com.molvenolakeresort.controllers.hotel;

import com.molvenolakeresort.models.hotel.*;
import com.molvenolakeresort.repositories.hotel.RoomRepository;
import com.molvenolakeresort.views.hotel.RoomInformationView;
import org.json.simple.JSONObject;
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

            view.setRoomNumber(room.getRoomNumber());
            view.setRoomStatus(room.getRoomStatus());
            view.setRoomBlocked(room.getRoomBlocked());
            view.setNumberOfBeds(roomAmenities.getKingSizeBeds() +
                    roomAmenities.getQueenSizeBeds() +
                    roomAmenities.getSingleSizeBeds());

            for (Reservation reservation : room.getReservations()) {
                LocalDate today = LocalDate.now();

                boolean checkedIn = reservation.getCheckInDate() != null && reservation.getCheckOutDate() == null;

                if ((today.compareTo(reservation.getStartDate().toLocalDate()) >= 0 &&
                        today.compareTo(reservation.getEndDate().toLocalDate()) <= 0) || checkedIn) {


                    for (ReservationGuest reservationGuest : reservation.getReservationGuests()) {
                        if (reservationGuest.isMainBooker()) {
                            Guest guest = reservationGuest.getGuest();
                            Address address = guest.getAddress();
                            view.setLastName(guest.getLastName());
                            view.setFirstName(guest.getFirstName());
                            view.setCountry(address.getCountry());
                            break;
                        }
                    }
                    view.setStartDate(reservation.getStartDate());
                    view.setEndDate(reservation.getEndDate());
                    view.setCheckedIn(checkedIn);
                    break;
                }
            }
            result.add(view);
        }
        return result;
    }
}
