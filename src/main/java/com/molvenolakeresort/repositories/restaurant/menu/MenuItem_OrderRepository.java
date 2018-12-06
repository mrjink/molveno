package com.molvenolakeresort.repositories.restaurant.menu;

import com.molvenolakeresort.models.restaurant.menu.MenuItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItem_OrderRepository extends JpaRepository<MenuItemOrder, Long> {
}
