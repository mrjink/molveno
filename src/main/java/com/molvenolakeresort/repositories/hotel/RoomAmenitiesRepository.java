package com.molvenolakeresort.repositories.hotel;

import com.molvenolakeresort.models.hotel.Guest;
import com.molvenolakeresort.models.hotel.RoomAmenities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomAmenitiesRepository extends JpaRepository<RoomAmenities, Long> {
}
