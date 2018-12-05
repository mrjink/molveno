package com.molvenolakeresort.repositories.restaurant;

import com.molvenolakeresort.models.restaurant.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, Long> {
}
