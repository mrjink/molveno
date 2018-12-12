package com.molvenolakeresort.services.impl;


import com.molvenolakeresort.models.generic.security.Profile;
import com.molvenolakeresort.models.generic.security.User;
import com.molvenolakeresort.repositories.generic.ProfileRepository;
import com.molvenolakeresort.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomAuthentication implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication auth)
            throws AuthenticationException {

        String username = auth.getName();
        String password = auth.getCredentials().toString();

        User user = null;
        //user = userService.findGuest(username);
        //user = userService.findEmployee(username);
        if(user==null){
            throw new BadCredentialsException("Username Not Found");
        }

        if(!password.equals(user.getPassword())){
            throw new BadCredentialsException("Username Or Password Is invalid");
        }


        return new UsernamePasswordAuthenticationToken(username,password,
                Arrays.asList(new SimpleGrantedAuthority(user.getRole().getName())));
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

}

