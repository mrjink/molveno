package com.molvenolakeresort.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.time.LocalDate;

@Component
public class StartUpImpl {

    @Autowired
    GenericServiceImpl genericService;

    @Autowired
    UserServiceImpl userService;

    public StartUpImpl() {}

    private Country[] initCountries() throws IOException, NullPointerException
    {
        Country[] retCountries = new Country[0];
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("json/country.json").getFile());
        if (file.canRead()) {
            StringBuilder json = new StringBuilder();

            BufferedReader br = new BufferedReader(new FileReader(file));
            String sSection;
            while ((sSection = br.readLine()) != null)
                json.append(sSection + "\n");

            ObjectMapper mapper = new ObjectMapper();
            retCountries = mapper.readValue(file, Country[].class);
            if (retCountries == null) {
                retCountries = new Country[0];
            }
        }

        return retCountries;
    }

    @PostConstruct
    public void init(){
        ServerLogger.log("Start of start-up.");
        try {
            Country[] countries = initCountries();
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

        GuestInformation guestInformation = new GuestInformation();
        guestInformation.setDateOfBirth(LocalDate.of(1990, 01,01));
        guestInformation.setSubscribedToNewsletter(true);

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
    }
}
