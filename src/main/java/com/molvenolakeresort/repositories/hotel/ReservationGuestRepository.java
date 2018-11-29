package com.molvenolakeresort.repositories.hotel;

import com.molvenolakeresort.models.hotel.ReservationGuest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationGuestRepository extends JpaRepository<ReservationGuest, Long> {
}
