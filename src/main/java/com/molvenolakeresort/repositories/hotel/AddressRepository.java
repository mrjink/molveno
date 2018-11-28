package com.molvenolakeresort.repositories.hotel;

import com.molvenolakeresort.models.hotel.Address;
import com.molvenolakeresort.models.hotel.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
