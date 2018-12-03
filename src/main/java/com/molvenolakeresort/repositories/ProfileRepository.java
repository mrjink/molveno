package com.molvenolakeresort.repositories;

import com.molvenolakeresort.models.generic.security.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
