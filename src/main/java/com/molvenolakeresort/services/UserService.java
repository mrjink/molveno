package com.molvenolakeresort.services;

import com.molvenolakeresort.models.generic.security.Privilege;
import com.molvenolakeresort.models.generic.security.Profile;
import com.molvenolakeresort.models.generic.security.Role;
import com.molvenolakeresort.models.generic.security.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findEmployee(long id);

    Iterable<User> findAllEmployees();

    User createEmployee(User employee);

    Iterable<User> createEmployees(User[] users);

    User findUserByUsername(String username);

    Optional<Profile> findVisitor(long id);

    Iterable<Profile> findAllVisitors();

    Profile createVisitor(Profile visitor);

    Optional<Profile> findGuest(long id);

    Iterable<Profile> findAllGuests();

    Profile createGuest(Profile guest);

    Optional<Role> findRole(long id);

    Iterable<Role> findAllRoles();

    Role createRole(Role role);

    Iterable<Role> createRoles(Role[] roles);

    Role findRoleByName(String name);

    Privilege createPrivilege(Privilege privilege);

    Iterable<Privilege> createPrivileges(Privilege[] privileges);

}
