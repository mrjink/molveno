package com.molvenolakeresort.controllers.generic;

import com.molvenolakeresort.controllers.ControllerPingTest;
import com.molvenolakeresort.models.generic.security.Profile;
import com.molvenolakeresort.services.GenericService;
import com.molvenolakeresort.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Optional;

@RestController
@RequestMapping("/api/guests/")
public class GuestController implements ControllerPingTest {

    @Inject
    GenericService genericService;

    @Inject
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getGuests()
    {
        ResponseEntity entity;

        entity = new ResponseEntity<Iterable<Profile>>(userService.findAllGuests(), HttpStatus.OK);

        return entity;
    }

    @RequestMapping(value = "/{index}", method = RequestMethod.GET)
    public ResponseEntity getGuest(@PathVariable("index") long index)
    {
        ResponseEntity entity;

        entity = new ResponseEntity<Optional<Profile>>(userService.findGuest(index), HttpStatus.OK);

        return entity;
    }

}
