package com.molvenolakeresort.repositories.hotel;

import com.molvenolakeresort.models.hotel.Guest;
import com.molvenolakeresort.views.hotel.GuestInformationView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "guest")
public interface GuestRepository extends JpaRepository<Guest, Long> {

}
