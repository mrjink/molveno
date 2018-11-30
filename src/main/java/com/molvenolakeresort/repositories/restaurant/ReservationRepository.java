package com.molvenolakeresort.repositories.restaurant;

import com.molvenolakeresort.models.restaurant.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
