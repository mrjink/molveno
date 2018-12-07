package com.molvenolakeresort.repositories.generic;

import com.molvenolakeresort.models.generic.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM User u WHERE u.username = ?1")
    boolean exists(String username);

    @Query("SELECT u FROM User u JOIN Role r ON r.id = u.role AND r.isEmployeeRole = true AND u.id = ?1 ")
    Optional<User> findEmployee(long id);

    @Query("SELECT u FROM User u JOIN Role r ON r.id = u.role AND r.isEmployeeRole = true")
    Iterable<User> findAllEmployees();

    User findByUsername(String username);
}
