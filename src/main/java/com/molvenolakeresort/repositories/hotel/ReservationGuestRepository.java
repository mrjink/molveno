package com.molvenolakeresort.repositories.hotel;

import com.molvenolakeresort.models.hotel.ReservationGuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "reservation-guest")
public interface ReservationGuestRepository extends JpaRepository<ReservationGuest, Long> {
}
