package com.molvenolakeresort.controllers.event;

import com.molvenolakeresort.models.event.User;
import com.molvenolakeresort.repositories.event.UserRepository_TEMPLATE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/user")
public class UserController {

@Autowired
private UserRepository_TEMPLATE userRepositoryTEMPLATE;

    public UserController(UserRepository_TEMPLATE userRepositoryTEMPLATE) {
        this.userRepositoryTEMPLATE = userRepositoryTEMPLATE;
    }

    @GetMapping(value = "all")
    public Iterable<User> getAll() {
        return userRepositoryTEMPLATE.findAll();
    }
}
