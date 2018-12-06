package com.molvenolakeresort.controllers.hotel;

import com.molvenolakeresort.mappers.hotel.GuestMapper;
import com.molvenolakeresort.models.hotel.Guest;
import com.molvenolakeresort.repositories.hotel.GuestRepository;
import com.molvenolakeresort.views.hotel.GuestInformationView;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/guest/")
public class GuestController {

    private GuestRepository guestRepository;
    public GuestController(GuestRepository guestRepository) { this.guestRepository = guestRepository; }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<GuestInformationView> getAll() {
        List<GuestInformationView> result = new ArrayList<>();
        for (Guest guest : this.guestRepository.findAll()) {
            result.add(GuestMapper.mapGuestToGuestInformationView(guest));
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
