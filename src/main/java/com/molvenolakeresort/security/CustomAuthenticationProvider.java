package com.molvenolakeresort.security;


import com.molvenolakeresort.models.generic.security.User;
import com.molvenolakeresort.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;

@ManagedBean
@Component
    public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    public CustomAuthenticationProvider() {
        super();
    }

    @Override
    public Authentication authenticate(Authentication auth)
            throws AuthenticationException {

        String username = auth.getName();
        String password = auth.getCredentials().toString();

        User user = userService.findUserByUsername(username);
        //user = userService.findGuest(username);
        //user = userService.findEmployee(username);
        if(user==null){
            throw new BadCredentialsException("Username Not Found");
        }

        if(!PasswordEncryption.isMatchingPassword(password, user.getPassword())){
            throw new BadCredentialsException("Username Or Password Is invalid");
        }

        return new UsernamePasswordAuthenticationToken(username,password,
                user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(
                UsernamePasswordAuthenticationToken.class);
    }

}

