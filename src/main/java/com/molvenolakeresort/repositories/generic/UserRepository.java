package com.molvenolakeresort.repositories.generic;

import com.molvenolakeresort.models.generic.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
