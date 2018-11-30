package com.molvenolakeresort.models.restaurant.exceptions;

public class ReservationNotFoundException extends Exception {

        public ReservationNotFoundException(Long id) {
            super("Could not find reservation with id " + id);
        }

}
