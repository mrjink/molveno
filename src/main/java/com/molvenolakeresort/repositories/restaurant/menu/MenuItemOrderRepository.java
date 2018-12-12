package com.molvenolakeresort.repositories.restaurant.menu;

import com.molvenolakeresort.models.restaurant.menu.MenuItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemOrderRepository extends JpaRepository<MenuItemOrder, Long> {
}
