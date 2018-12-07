package com.molvenolakeresort.repositories.generic;

import com.molvenolakeresort.models.generic.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN TRUE ELSE FALSE END FROM Role r WHERE r.name = ?1")
    boolean exists(String name);
}
