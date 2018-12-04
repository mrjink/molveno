package com.molvenolakeresort.repositories.generic;

import com.molvenolakeresort.models.generic.security.Profile;
import com.molvenolakeresort.models.generic.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByEmail(@Param("email") String email);
    Profile findByPhoneNumber(@Param("phonenumber") String phonenumber);
}
