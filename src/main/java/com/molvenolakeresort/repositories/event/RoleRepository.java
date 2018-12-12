package com.molvenolakeresort.repositories.event;

import com.molvenolakeresort.models.event.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "role")
public interface RoleRepository extends JpaRepository<Role,Long> {
}
