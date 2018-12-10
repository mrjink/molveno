package com.molvenolakeresort.services.impl;

import com.molvenolakeresort.ServerLogger;
import com.molvenolakeresort.models.generic.security.Privilege;
import com.molvenolakeresort.models.generic.security.Profile;
import com.molvenolakeresort.models.generic.security.Role;
import com.molvenolakeresort.models.generic.security.User;
import com.molvenolakeresort.repositories.generic.PrivilegeRepository;
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
    private ProfileRepository profileRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    private Profile createProfileTemplate(Profile profile, boolean isVisitor) {
        Profile newProfile = new Profile();
        newProfile.setFirstName(profile.getFirstName());
        newProfile.setMiddleName(profile.getMiddleName());
        newProfile.setLastName(profile.getLastName());
        newProfile.setVisitor(isVisitor);
        if (profile.getEmail() != null) {
            //used for the participant of an event
            newProfile.setEmail(profile.getEmail());
        }
        if (profile.getPhoneNumber() != null) {
            //used for the visitor of the restaurant
            newProfile.setPhoneNumber(profile.getPhoneNumber());
        }
        if (newProfile != null) {
            ServerLogger.log(String.format("New profile (id, isVisitor): %s, %s", newProfile.getId(), newProfile.isVisitor()));
        }
        return newProfile;
    }

    @Override
    public Optional<User> findEmployee(long id) {
        return userRepository.findEmployee(id);
    }

    @Override
    public User createEmployee(User employee) {
        if (userRepository.exists(employee.getUsername())) return null;

        //only fill entries used by employee
        User newUser = new User();
        newUser.setPassword(employee.getPassword());
        if (employee.getRole() != null) {
            newUser.setRole(employee.getRole());
        } else {
            Role role = findRoleByName("EMPLOYEE");
            newUser.setRole(role);
        }
        if (employee != null) {
            ServerLogger.log(String.format("New employee (id): %s", employee.getId()));
        }

        return userRepository.save(newUser);
    }

    @Override
    public Iterable<User> findAllEmployees() {
        return userRepository.findAllEmployees();
    }

    @Override
    public Optional<Profile> findVisitor(long id) {
        return profileRepository.findRestaurantVisitor(id);
    }


    @Override
    public Profile createVisitor(Profile visitor) {
        if (profileRepository.exists(visitor.getEmail(), visitor.getPhoneNumber())) return null;
        //only fill entries used by visitor
        return profileRepository.save(createProfileTemplate(visitor, true));
    }

    @Override
    public Iterable<Profile> findAllVisitors() {
        return profileRepository.findAllRestaurantVisitors();
    }

    @Override
    public Optional<Profile> findGuest(long id) {
        return profileRepository.findGuest(id);
    }

    @Override
    public Profile createGuest(Profile guest) {
        if (userRepository.exists(guest.getUser().getUsername())) return null;

        Profile template = null;

        Profile eventVisitor = profileRepository.findByEmail(guest.getEmail());
        Profile restaurantVisitor = profileRepository.findByPhoneNumber(guest.getPhoneNumber());

        if (eventVisitor != null && restaurantVisitor != null) {
            //upgrade event visitor and (transfer and) destroy the restaurant visitors content.
            template = eventVisitor;
        } else if (eventVisitor != null) {
            template = eventVisitor;
        } else if (restaurantVisitor != null) {
            template = restaurantVisitor;
        }

        //if the guest does not yet exist as a visitor create one.
        if (template == null) {
            template = createProfileTemplate(guest, false);
            if (template != null) {
                ServerLogger.log(String.format("New guest (id): %s", template.getId()));
            }
        } else {
            template.setVisitor(false);
            template.setEmail(guest.getEmail());
            template.setFirstName(guest.getFirstName());
            template.setMiddleName(guest.getMiddleName());
            template.setLastName(guest.getLastName());
            template.setUser(guest.getUser());
            template.setGuestInformation(guest.getGuestInformation());
            if (template != null) {
                ServerLogger.log(String.format("Guest mutated (id): %s", template.getId()));
            }
        }

        return profileRepository.save(template);
    }

    @Override
    public Iterable<Profile> findAllGuests() {
        return profileRepository.findAllGuests();
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
        if (roles != null) {
            for (int i = 0; i < roles.length; i++) {
                if (!roleRepository.exists(roles[i].getName())) {
                    ((ArrayList<Role>) roleIterable).add(roles[i]);
                }
            }
        }

        roleIterable = roleRepository.saveAll(roleIterable);
        ServerLogger.log(String.format("Mutated %s records in roles.", ((List<Role>) roleIterable).size()));
        return roleIterable;
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Privilege createPrivilege(Privilege privilege) {
        if (privilegeRepository.exists(privilege.getName())) return null;
        return privilegeRepository.save(privilege);
    }

    @Override
    public Iterable<Privilege> createPrivileges(Privilege[] privileges) {
        Iterable<Privilege> privilegeIterable = new ArrayList<>();
        if (privileges != null) {
            for (int i = 0; i < privileges.length; i++) {
                if (!privilegeRepository.exists(privileges[i].getName())) {
                    ((ArrayList<Privilege>) privilegeIterable).add(privileges[i]);
                }
            }
        }

        privilegeIterable = privilegeRepository.saveAll(privilegeIterable);
        ServerLogger.log(String.format("Mutated %s records in privileges.", ((List<Privilege>) privilegeIterable).size()));
        return privilegeIterable;
    }

    public Iterable<User> createEmployees(User[] users) {

        Iterable<User> userIterable = new ArrayList<>();
        if (users != null) {
            for (int i = 0; i < users.length; i++) {
                if (!userRepository.exists(users[i].getUsername())) {
                    ((ArrayList<User>) userIterable).add(users[i]);
                }
            }
        }

        userIterable = userRepository.saveAll(userIterable);
        ServerLogger.log(String.format("Mutated %s records in users(employee).", ((List<User>) userIterable).size()));
        return userIterable;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
