package com.molvenolakeresort.services;

import com.molvenolakeresort.models.generic.security.Profile;
import com.molvenolakeresort.models.generic.security.Role;

import java.util.Optional;

public interface UserService {
    Optional<Profile> findEmployee(long id);
    Profile createEmployee(Profile employee);
    Iterable<Profile> findAllEmployees();

    Optional<Profile> findVisitor(long id);
    Profile createVisitor(Profile visitor);
    Iterable<Profile> findAllVisitors();

    Optional<Profile> findGuest(long id);
    Profile createGuest(Profile visitor);
    Iterable<Profile> findAllGuests();

    Iterable<Role> findAllRoles();
    Optional<Role> findRole(long id);
    Role createRole(Role role);
    Iterable<Role> createRoles(Role[] roles);
    Role findRoleByName(String name);
}
