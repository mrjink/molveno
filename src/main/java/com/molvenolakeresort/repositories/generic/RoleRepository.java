package com.molvenolakeresort.repositories.generic;

import com.molvenolakeresort.models.generic.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(@Param("name") String name);
}
