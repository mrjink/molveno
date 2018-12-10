package com.molvenolakeresort.repositories.restaurant;

import com.molvenolakeresort.models.restaurant.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {
}
