package com.molvenolakeresort.repositories.hotel;

import com.molvenolakeresort.models.hotel.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "hotelReservationRepository")
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
