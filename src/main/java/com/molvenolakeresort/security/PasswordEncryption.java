package com.molvenolakeresort.security;

import com.molvenolakeresort.models.generic.security.User;
import org.exolab.castor.types.DateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

public class PasswordEncryption {

    /**
     * Might not be necessary.
     * @return hash matches saved hash.
     */
    public final boolean checkHash()
    {
        return false;
    }

    @Bean
    public static PasswordEncoder getEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    public static String getHashedPassword(String unhashed)
    {
        return getEncoder().encode(unhashed);
    }

    public static boolean isMatchingPassword(String unhashed, String hashed) { return getEncoder().matches(unhashed, hashed); }

    public static String getPasswordRecoveryUri(User user)
    {
        return getEncoder().encode(user.getUsername().concat(LocalDateTime.now().toString()));
    }
}
