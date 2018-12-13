package com.molvenolakeresort.controllers.generic;

import com.molvenolakeresort.controllers.ControllerPingTest;
import com.molvenolakeresort.models.generic.security.Profile;
import com.molvenolakeresort.services.GenericService;
import com.molvenolakeresort.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.swing.text.html.Option;
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

    @GetMapping(value = "/{index}")
    public ResponseEntity getGuest(UsernamePasswordAuthenticationToken principal, @PathVariable("index") long index)
    {
        ResponseEntity entity = new ResponseEntity<Profile>(HttpStatus.OK);

        Optional<Profile> guestProfile = userService.findGuest(index);
        if(guestProfile.isPresent()) {
            boolean hasOtherRole = true;
            if(principal.getAuthorities() != null) {
                if(principal.getAuthorities().size() > 0) {
                    for (GrantedAuthority authority : principal.getAuthorities()) {
                        if (authority.getAuthority().equals("ROLE_GUEST") || authority.getAuthority().equals("GUEST")) {
                            hasOtherRole = false;
                        }
                    }
                } else {
                    hasOtherRole = false;
                }
            } else {
                hasOtherRole = false;
            }

            if(guestProfile.get().getUser().getUsername().equals(principal.getName()) || hasOtherRole) {
                entity = new ResponseEntity<Optional<Profile>>(guestProfile, HttpStatus.OK);
            }
        }
        return entity;
    }

    @GetMapping(value = "/register")
    public ResponseEntity registerGuest(Profile guest){
        ResponseEntity entity;

        entity = new ResponseEntity<Profile>(userService.createGuest(guest), HttpStatus.OK);

        return entity;
    }

}
