package com.molvenolakeresort.repositories.hotel;

import com.molvenolakeresort.models.hotel.Address;
import com.molvenolakeresort.models.hotel.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "address")
public interface AddressRepository extends JpaRepository<Address, Long> {
}
