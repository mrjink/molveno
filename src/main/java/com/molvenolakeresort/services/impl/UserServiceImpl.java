package com.molvenolakeresort.services.impl;

import com.molvenolakeresort.models.generic.security.Profile;
import com.molvenolakeresort.models.generic.security.Role;
import com.molvenolakeresort.models.generic.security.User;
import com.molvenolakeresort.repositories.generic.ProfileRepository;
import com.molvenolakeresort.repositories.generic.RoleRepository;
import com.molvenolakeresort.repositories.generic.UserRepository;
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
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    private Profile createProfileTemplate(Profile profile, boolean isVisitor)
    {
        Profile newProfile = new Profile();
        newProfile.setFirstName(profile.getFirstName());
        newProfile.setMiddleName(profile.getMiddleName());
        newProfile.setLastName(profile.getLastName());
        newProfile.setVisitor(isVisitor);
        if(profile.getEmail() != null) {
            //used for the participant of an event
            newProfile.setEmail(profile.getEmail());
        }
        if(profile.getPhoneNumber() != null) {
            //used for the visitor of the restaurant
            newProfile.setPhoneNumber(profile.getPhoneNumber());
        }
        return newProfile;
    }

    @Override
    public Optional<User> findEmployee(long id) {
        return Optional.empty();
    }

    @Override
    public User createEmployee(User employee) {
        //only fill entries used by employee
        User newUser = new User();
        newUser.setPassword(employee.getPassword());
        if(employee.getRole() != null) {
            newUser.setRole(employee.getRole());
        }
        else
        {
            Role role = findRoleByName("EMPLOYEE");
            newUser.setRole(role);
        }

        return userRepository.save(newUser);
    }

    @Override
    public Iterable<User> findAllEmployees() {
        return null;
    }

    @Override
    public Optional<Profile> findVisitor(long id) {
        return Optional.empty();
    }


    @Override
    public Profile createVisitor(Profile visitor) {
        //only fill entries used by visitor
        return profileRepository.save(createProfileTemplate(visitor, true));
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
    public Profile createGuest(Profile guest) {

        Profile template = null;

        Profile eventVisitor = profileRepository.findByEmail(guest.getEmail());
        Profile restaurantVisitor = profileRepository.findByPhoneNumber(guest.getPhoneNumber());

        if(eventVisitor != null && restaurantVisitor != null)
        {
            //upgrade event visitor and (transfer and) destroy the restaurant visitors content.
            template = eventVisitor;
        }
        else if(eventVisitor != null)
        {
            template = eventVisitor;
        }
        else if(restaurantVisitor != null)
        {
            template = restaurantVisitor;
        }

        //if the guest does not yet exist as a visitor create one.
        if(template == null)
        {
            template = createProfileTemplate(guest, false);
        } else
        {
            template.setVisitor(false);
            template.setEmail(guest.getEmail());
            template.setFirstName(guest.getFirstName());
            template.setMiddleName(guest.getMiddleName());
            template.setLastName(guest.getLastName());
            template.setUser(guest.getUser());
            template.setGuestInformation(guest.getGuestInformation());
        }

        return profileRepository.save(template);
    }

    @Override
    public Iterable<Profile> findAllGuests() {
        return null;
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
        ServerLogger.log(String.format("Mutated %s records.", ((List<Role>) roleIterable).size()));
        return roleIterable;
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}
