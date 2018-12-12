package com.molvenolakeresort.repositories.generic;

import com.molvenolakeresort.models.generic.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository  extends JpaRepository<User, Long> {
    boolean exists(@Param("username") String username);
}
