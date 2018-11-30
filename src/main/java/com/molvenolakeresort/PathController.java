package com.molvenolakeresort;

import org.springframework.stereotype.Controller;
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
}