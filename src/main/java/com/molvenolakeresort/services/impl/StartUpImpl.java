package com.molvenolakeresort.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.molvenolakeresort.models.generic.Country;
import com.molvenolakeresort.models.generic.security.Profile;
import com.molvenolakeresort.models.generic.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
        Role visitorRole = new Role("VISITOR");
        Role employeeRole = new Role("EMPLOYEE");

        Role userDeletePrivilege = new Role("USER_DELETE");
        Role userEditPrivilege = new Role("USER_EDIT");
        Role userViewPrivilege = new Role("USER_VIEW");
        userService.createRoles(new Role[]{ guestRole, visitorRole, employeeRole, userDeletePrivilege, userEditPrivilege, userViewPrivilege });

        guestRole = userService.findRoleByName(guestRole.getName());

        Profile user = new Profile();
        user.setFirstName("test");
        user.setLastName("ing");
        user.setUsername("testing");
        user.addRole(guestRole);
        user = userService.createVisitor(user);

        Profile user1 = new Profile();
        user1.addRole(employeeRole);
        user1.setUsername(employeeRole.getName());
        user1 = userService.createEmployee(user1);
        ServerLogger.log("End of start-up.");
    }
}
