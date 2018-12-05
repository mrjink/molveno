package com.molvenolakeresort.repositories.event;

import com.molvenolakeresort.models.event.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository_TEMPLATE extends JpaRepository<User, Long> {
}
