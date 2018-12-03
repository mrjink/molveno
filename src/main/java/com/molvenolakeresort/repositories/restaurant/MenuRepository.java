package com.molvenolakeresort.repositories.restaurant;

import com.molvenolakeresort.models.restaurant.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long>{
}