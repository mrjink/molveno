package com.molvenolakeresort.repositories.generic;

import com.molvenolakeresort.models.generic.security.Profile;
import com.molvenolakeresort.models.generic.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByEmail(String email);
    Profile findByPhoneNumber(String phonenumber);
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM Profile p WHERE p.email = ?1 OR p.phoneNumber = ?2 ")
    boolean exists(String email, String phonenumber);

    @Query("SELECT p FROM Profile p WHERE p.isVisitor = false AND p.id =:id")
    Optional<Profile> findGuest(@Param("id") long id);
    @Query("SELECT p FROM Profile p WHERE p.isVisitor = true AND p.phoneNumber IS NOT NULL AND p.email IS NULL AND p.id =:id")
    Optional<Profile> findEventParticipant(@Param("id") long id);
    @Query("SELECT p FROM Profile p WHERE p.isVisitor = true AND p.phoneNumber IS NULL AND p.email IS NOT NULL AND p.id =:id")
    Optional<Profile> findRestaurantVisitor(@Param("id") long id);

    @Query("SELECT p FROM Profile p WHERE p.isVisitor = false")
    Iterable<Profile> findAllGuests();
    @Query("SELECT p FROM Profile p WHERE p.isVisitor = true AND p.phoneNumber IS NOT NULL AND p.email IS NULL")
    Iterable<Profile> findAllEventParticipants();
    @Query("SELECT p FROM Profile p WHERE p.isVisitor = true AND p.phoneNumber IS NULL AND p.email IS NOT NULL")
    Iterable<Profile> findAllRestaurantVisitors();
}
