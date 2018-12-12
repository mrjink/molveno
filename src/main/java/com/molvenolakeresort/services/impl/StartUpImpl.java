package com.molvenolakeresort.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.molvenolakeresort.models.generic.Address;
import com.molvenolakeresort.models.generic.Country;
import com.molvenolakeresort.models.generic.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;

@Component
public class StartUpImpl {

    @Autowired
    GenericServiceImpl genericService;

    @Autowired
    UserServiceImpl userService;

    public StartUpImpl() {}

    public class JSONReader<T>{

        public T[] initObject(Class<T> type, String resourceNameOrPath) throws IOException, NullPointerException
        {
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

    @PostConstruct
    public void init(){
        ServerLogger.log("==> Dataset - Initializing records...");
        try {
            Country[] countries = new JSONReader<Country>().initObject(Country.class, "json/country.json");
            genericService.createCountries(countries);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        Role guestRole = new Role ("GUEST");
        Role employeeRole = new Role("ADMINISTRATOR", true);
        Role employeeRole2 = new Role("MANAGER", true);
        userService.createRoles(new Role[]{ guestRole, employeeRole, employeeRole2 });

        guestRole = userService.findRoleByName(guestRole.getName());

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

        Address address = new Address("ardennen", null,"22", "helmond", "5706 RE", country);

        GuestInformation guestInformation = new GuestInformation();
        guestInformation.setDateOfBirth(LocalDate.of(1990, 01,01));
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
}
