package com.molvenolakeresort.controllers.hotel;

import com.molvenolakeresort.models.hotel.*;
import com.molvenolakeresort.repositories.hotel.RoomRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@RestController
@RequestMapping("api/rooms/")
public class RoomController {



    private RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public JSONArray getAll() {
        JSONArray result = new JSONArray();
        for (Room room : this.roomRepository.findAll()) {
            JSONObject row = new JSONObject();
            row.put("roomNumber", room.getRoomNumber());
            row.put("roomStatus", room.getRoomStatus());
            row.put("roomBlocked", room.getRoomBlocked());
            RoomAmenities roomAmenities = room.getRoomAmenities();
            row.put("numberOfBeds",
                    roomAmenities.getKingSizeBeds() +
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

                            row.put("lastName", guest.getLastName());
                            row.put("firstName", guest.getFirstName());
                            Address address = guest.getAddress();
                            row.put("country", address.getCountry());
                        }
                    }
                    row.put("startDate", reservation.getStartDate());
                    row.put("endDate", reservation.getEndDate());
                    row.put("checkedIn", checkedIn);
                    break;
                }
            }
            result.add(row);
        }
        return result;
    }
}
