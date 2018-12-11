package com.molvenolakeresort.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {

    @RequestMapping(path = {"/restaurant", "/restaurant/"})
    public  String getRestaurant(){
        return "/restaurant/restaurant.html";
    }


    @RequestMapping(path = {"/restaurant/reservation", "/restaurant/reservation/"})
    public  String getReservation(){
        return "/restaurant/reservation/reservation.html";
    }


    @RequestMapping(path = {"/restaurant/reservation/confirm", "/restaurant/reservation/confirm/"})
    public  String getConfirmation(){
        return "/restaurant/reservation/confirm.html";
    }

    @RequestMapping(path = {"/restaurant/menu", "/restaurant/menu/"})
    public  String getMenu() { return "/restaurant/menu/menu.html";
    }

    @GetMapping("/")
    public String root()
    {
        return "index";
    }

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
}