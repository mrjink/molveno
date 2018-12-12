package com.molvenolakeresort.controllers.hotel;

import com.molvenolakeresort.mappers.hotel.GuestMapper;
import com.molvenolakeresort.mappers.hotel.PendingReservationMapper;
import com.molvenolakeresort.models.hotel.Guest;
import com.molvenolakeresort.models.hotel.Reservation;
import com.molvenolakeresort.models.hotel.ReservationGuest;
import com.molvenolakeresort.models.hotel.Room;
import com.molvenolakeresort.repositories.hotel.*;
import com.molvenolakeresort.views.hotel.GuestInformationView;
import com.molvenolakeresort.views.hotel.PendingReservationInformationView;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/reservation/")
public class PendingReservationController {

    private ReservationRepository reservationRepository;
    private GuestRepository guestRepository;
    private RoomRepository roomRepository;
    private InvoiceRepository invoiceRepository;
    private ReservationGuestRepository reservationGuestRepository;
    public PendingReservationController(ReservationRepository reservationRepository, GuestRepository guestRepository, RoomRepository roomRepository, InvoiceRepository invoiceRepository, ReservationGuestRepository reservationGuestRepository) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
        this.invoiceRepository = invoiceRepository;
        this.reservationGuestRepository = reservationGuestRepository;
    }

    @RequestMapping(value = "add/{id}", method = RequestMethod.POST)
    public void addReservation(@PathVariable long id, @RequestBody Reservation reservation) {
        //TEMP get first room and invoice
        reservation.setRooms(new HashSet<>(Collections.singletonList(roomRepository.getOne(1L))));
        reservation.setInvoices(new HashSet<>(Collections.singletonList(invoiceRepository.getOne(1L))));
        reservationRepository.save(reservation);
        Guest guest = guestRepository.getOne(id);
        ReservationGuest reservationGuest = new ReservationGuest();
        reservationGuest.setGuest(guest);
        reservationGuest.setReservation(reservation);
        reservationGuest.setMainBooker(true);
        reservationGuestRepository.save(reservationGuest);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<PendingReservationInformationView> getAll() {
        List<PendingReservationInformationView> result = new ArrayList<>();
        for (Reservation reservation : this.reservationRepository.findAll()) {
            if (!reservation.isApproved()) {
                result.add(PendingReservationMapper.mapReservationToPendingReservationInformationView(reservation));
            }
        }
        return result;
    }


    @RequestMapping(value = "set-approved/{id}", method = RequestMethod.PATCH)
    public void setApproved(@PathVariable long id, @RequestBody Reservation reservationFromWebsite) {
        Reservation reservationFromDatabase = reservationRepository.getOne(id);
        reservationFromDatabase.setApproved(reservationFromWebsite.isApproved());
        reservationRepository.save(reservationFromDatabase);
    }

}
