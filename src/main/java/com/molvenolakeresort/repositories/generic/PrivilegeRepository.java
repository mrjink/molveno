package com.molvenolakeresort.repositories.generic;

import com.molvenolakeresort.models.generic.security.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM Privilege p WHERE p.name = ?1")
    boolean exists(String name);
}
