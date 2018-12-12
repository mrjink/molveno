package com.molvenolakeresort.repositories.restaurant;

import com.molvenolakeresort.models.restaurant.RestaurantReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantReservationRepository extends JpaRepository<RestaurantReservation, Long> {
}
