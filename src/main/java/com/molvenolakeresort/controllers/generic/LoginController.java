package com.molvenolakeresort.controllers.generic;

import com.molvenolakeresort.controllers.ControllerPingTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login/")
public class LoginController implements ControllerPingTest{

    @GetMapping(value="/username")
    public String printUser(ModelMap model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username

        model.addAttribute("username", name);
        return "hello";
    }
}