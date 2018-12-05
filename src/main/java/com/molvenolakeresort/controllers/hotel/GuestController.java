package com.molvenolakeresort.controllers.hotel;

import com.molvenolakeresort.models.hotel.Guest;
import com.molvenolakeresort.models.hotel.Reservation;
import com.molvenolakeresort.models.hotel.ReservationGuest;
import com.molvenolakeresort.models.hotel.Room;
import com.molvenolakeresort.repositories.hotel.GuestRepository;
import com.molvenolakeresort.views.hotel.GuestInformationView;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/guests/")
public class GuestController {

    private GuestRepository guestRepository;
    public GuestController(GuestRepository guestRepository) { this.guestRepository = guestRepository; }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<GuestInformationView> getAll() {
        List<GuestInformationView> result = new ArrayList<>();
        for (Guest guest : this.guestRepository.findAll()) {
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
            result.add(view);
        }
        return result;
    }
    @RequestMapping(value = "newsletterStatus/{id}", method = RequestMethod.PATCH)
    public Guest setNewsLetterStatus(@PathVariable int id, @RequestBody Guest guestFromWebsite){
        Guest guestFromDatabase = guestRepository.getOne(id);
        guestFromDatabase.setNewsletterSubscribed(guestFromWebsite.isNewsletterSubscribed());
        guestRepository.save(guestFromDatabase);
        return guestFromDatabase;
    }

}
