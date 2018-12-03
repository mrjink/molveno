package com.molvenolakeresort.services.impl;

import com.molvenolakeresort.models.generic.security.Profile;
import com.molvenolakeresort.models.generic.security.Role;
import com.molvenolakeresort.models.generic.security.UserName;
import com.molvenolakeresort.repositories.generic.ProfileRepository;
import com.molvenolakeresort.repositories.generic.RoleRepository;
import com.molvenolakeresort.repositories.generic.UserNameRepository;
import com.molvenolakeresort.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    UserNameRepository userNameRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Optional<Profile> findEmployee(long id) {
        return Optional.empty();
    }

    @Override
    public Profile createEmployee(Profile employee) {
        //only fill entries used by employee
        Profile newProfile = new Profile();
        newProfile.setPassword(employee.getPassword());
        if(employee.getUsername() != null) {
            //used for the participant of an event
            employee.getUsername().setProfile(newProfile);
            newProfile.setUsername(employee.getUsername());
        }
        if(employee.getRoles() != null)
        {
            for(Role role : employee.getRoles())
            {
                role = findRoleByName(role.getName());
                role.addProfile(newProfile);
                roleRepository.save(role);
            }
        }
        else
        {
            Role role = findRoleByName("EMPLOYEE");
            role.addProfile(newProfile);
        }

        return profileRepository.save(newProfile);
    }

    @Override
    public Iterable<Profile> findAllEmployees() {
        return null;
    }

    @Override
    public Optional<Profile> findVisitor(long id) {
        return Optional.empty();
    }

    @Override
    public Profile createVisitor(Profile visitor) {
        //only fill entries used by visitor
        Profile newProfile = new Profile();
        newProfile.setFirstName(visitor.getFirstName());
        newProfile.setMiddleName(visitor.getMiddleName());
        newProfile.setLastName(visitor.getLastName());
        if(visitor.getUsername() != null) {
            //used for the participant of an event
            visitor.getUsername().setProfile(newProfile);
            newProfile.setUsername(visitor.getUsername());
        }
        if(visitor.getPhoneNumber() != null) {
            //used for the visitor of the restaurant
            visitor.getPhoneNumber().setProfile(newProfile);
            newProfile.setPhoneNumber(visitor.getPhoneNumber());
        }
        Role role = findRoleByName("VISITOR");
        role.addProfile(newProfile);

        return profileRepository.save(newProfile);
    }

    @Override
    public Iterable<Profile> findAllVisitors() {
        return null;
    }

    @Override
    public Optional<Profile> findGuest(long id) {
        return Optional.empty();
    }

    @Override
    public Profile createGuest(Profile visitor) {
        return null;
    }

    @Override
    public Iterable<Profile> findAllGuests() {
        return null;
    }

    @Override
    public Iterable<UserName> findAllUserNames() {
        return userNameRepository.findAll();
    }

    @Override
    public Optional<UserName> findUserName(long id) {
        return userNameRepository.findById(id);
    }

    @Override
    public UserName createUserName(UserName username) {
        return userNameRepository.save(username);
    }

    @Override
    public Iterable<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findRole(long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Iterable<Role> createRoles(Role[] roles) {
        Iterable<Role> roleIterable = new ArrayList<>();
        if(roles != null) {
            for (int i = 0; i < roles.length; i++)
            {
                ((ArrayList<Role>) roleIterable).add(roles[i]);
            }
        }

        roleIterable = roleRepository.saveAll(roleIterable);
        System.out.println(String.format("Mutated %s records.", ((List<Role>) roleIterable).size()));
        return roleIterable;
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}
