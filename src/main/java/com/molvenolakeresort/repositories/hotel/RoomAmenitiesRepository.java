package com.molvenolakeresort.repositories.hotel;

import com.molvenolakeresort.models.hotel.Guest;
import com.molvenolakeresort.models.hotel.RoomAmenities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "room-amenities")
public interface RoomAmenitiesRepository extends JpaRepository<RoomAmenities, Long> {
}
