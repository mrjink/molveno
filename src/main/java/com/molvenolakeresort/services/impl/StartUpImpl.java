package com.molvenolakeresort.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.molvenolakeresort.models.generic.Address;
import com.molvenolakeresort.models.generic.Country;
import com.molvenolakeresort.models.generic.security.*;
import com.molvenolakeresort.security.PasswordEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;

@Component
public class StartUpImpl {

    @Autowired
    private GenericServiceImpl genericService;

    @Autowired
    private UserServiceImpl userService;

    public StartUpImpl() {
    }

    @PostConstruct
    public void init() {
        ServerLogger.log("==> Dataset - Initializing records...");
        initialiseCountries();
        initialiseDefaultPermissions();
        initialiseDefaultRoles();
        initialiseDefaultUsers();

        Role guestRole = userService.findRoleByName("GUEST");

        Profile profileExample = new Profile();
        profileExample.setFirstName("test");
        profileExample.setLastName("ing");
        profileExample.setVisitor(false);
        profileExample.setPhoneNumber("+31643136264");

        User userExample = new User();
        userExample.setRole(guestRole);
        userExample.setUsername("temp-user");
        userExample.setPassword(PasswordEncryption.getHashedPassword("pwd"));
        userExample.setPasswordResetURI(PasswordEncryption.getPasswordRecoveryUri(userExample));

        Country country = genericService.findCountryByCode("NL");

        Address address = new Address("ardennen", null, "22", "helmond", "5706 RE", country);

        GuestInformation guestInformation = new GuestInformation();
        guestInformation.setDateOfBirth(LocalDate.of(1990, 01, 01));
        guestInformation.setSubscribedToNewsletter(true);
        guestInformation.setAddress(address);

        profileExample.setUser(userExample);
        profileExample.setGuestInformation(guestInformation);

        //generate a restaurant visitor (phone only)
        userService.createVisitor(profileExample);

        profileExample.setMiddleName("ing the th");
        profileExample.setPhoneNumber(null);
        profileExample.setEmail("test@test.com");

        //generate a event visitor (email only)
        userService.createVisitor(profileExample);

        //generate a guest from the event visitor
        userService.createGuest(profileExample);

        ServerLogger.log("==> Dataset - Initialized.");
    }

    private void initialiseDefaultPermissions() {
        try {
            Privilege[] privileges = new JSONReader<Privilege>().initObject(Privilege.class, "json/default-permissions.json");
            userService.createPrivileges(privileges);
        } catch (IOException e) {
            //non volatile error (file does not exist or locked), does not affect system
            ServerLogger.log(e.getMessage());
        } catch (NullPointerException e) {
            //volatile error, likely due to incorrect translation
            e.printStackTrace();
        }
    }

    private void initialiseDefaultUsers() {
        try {
            User[] users = new JSONReader<User>().initObject(User.class, "json/default-users.json");
            if (users != null) {
                for (int userIndex = 0; userIndex < users.length; userIndex++) {
                    users[userIndex].setRole(userService.findRoleByName(users[userIndex].getRole().getName()));
                    users[userIndex].setPassword(users[userIndex].getPassword(), false);
                    users[userIndex].setPasswordResetURI(PasswordEncryption.getPasswordRecoveryUri(users[userIndex]));
                }
            }
            userService.createEmployees(users);
        } catch (IOException e) {
            //non volatile error (file does not exist or locked), does not affect system
            ServerLogger.log(e.getMessage());
        } catch (NullPointerException e) {
            //volatile error, likely due to incorrect translation
            e.printStackTrace();
        }
    }

    private void initialiseDefaultRoles() {
        try {
            Role[] roles = new JSONReader<Role>().initObject(Role.class, "json/default-roles.json");
            userService.createRoles(roles);
        } catch (IOException e) {
            //non volatile error (file does not exist or locked), does not affect system
            ServerLogger.log(e.getMessage());
        } catch (NullPointerException e) {
            //volatile error, likely due to incorrect translation
            e.printStackTrace();
        }
    }

    private void initialiseCountries() {
        try {
            Country[] countries = new JSONReader<Country>().initObject(Country.class, "json/country.json");
            genericService.createCountries(countries);
        } catch (IOException e) {
            //non volatile error (file does not exist or locked), does not affect system
            ServerLogger.log(e.getMessage());
        } catch (NullPointerException e) {
            //volatile error, likely due to incorrect translation
            e.printStackTrace();
        }
    }

    public class JSONReader<T> {

        public T[] initObject(Class<T> type, String resourceNameOrPath) throws IOException, NullPointerException {
            Class<T> classOfT;
            T[] returnArray = (T[]) Array.newInstance(type, 0);

            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(resourceNameOrPath).getFile());
            if (file.canRead()) {
                ObjectMapper mapper = new ObjectMapper();
                returnArray = (T[]) mapper.readValue(file, returnArray.getClass());
                if (returnArray == null) {
                    returnArray = (T[]) Array.newInstance(type, 0);
                }
            }
            return returnArray;
        }
    }
}
