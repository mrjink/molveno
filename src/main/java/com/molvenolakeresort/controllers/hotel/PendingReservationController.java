package com.molvenolakeresort.controllers.hotel;

import com.molvenolakeresort.mappers.hotel.GuestMapper;
import com.molvenolakeresort.mappers.hotel.PendingReservationMapper;
import com.molvenolakeresort.models.hotel.Guest;
import com.molvenolakeresort.models.hotel.Reservation;
import com.molvenolakeresort.repositories.hotel.GuestRepository;
import com.molvenolakeresort.repositories.hotel.ReservationRepository;
import com.molvenolakeresort.views.hotel.GuestInformationView;
import com.molvenolakeresort.views.hotel.PendingReservationInformationView;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/reservation/")
public class PendingReservationController {

    private ReservationRepository reservationRepository;
    public PendingReservationController(ReservationRepository reservationRepository) { this.reservationRepository = reservationRepository; }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<PendingReservationInformationView> getAll() {
        List<PendingReservationInformationView> result = new ArrayList<>();
        for (Reservation reservation : this.reservationRepository.findAll()) {
            result.add(PendingReservationMapper.mapReservationToPendingReservationInformationView(reservation));
        }
        return result;
    }

    //@TODO make update call for setting approved and setting room number.

}
