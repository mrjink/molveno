package com.molvenolakeresort.repositories.hotel;

import com.molvenolakeresort.models.hotel.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository(value = "hotel-reservation-repository")
@RepositoryRestResource(path = "reservation")
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
