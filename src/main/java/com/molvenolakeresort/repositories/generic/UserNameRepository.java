package com.molvenolakeresort.repositories.generic;

import com.molvenolakeresort.models.generic.security.UserName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserNameRepository extends JpaRepository<UserName, Long> {

}
