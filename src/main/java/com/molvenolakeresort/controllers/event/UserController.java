package com.molvenolakeresort.controllers.event;

import com.molvenolakeresort.models.event.User;
import com.molvenolakeresort.repositories.event.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/user")
public class UserController {

@Autowired
private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }
}
