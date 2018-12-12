package com.molvenolakeresort.models.generic.security;

import org.exolab.castor.types.DateTime;
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

    private static PasswordEncoder getEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    public static String getHashedPassword(String unhashed)
    {
        return getEncoder().encode(unhashed);
    }

    public static String getPasswordRecoveryUri(User user)
    {
        return getEncoder().encode(user.getUsername().concat(LocalDateTime.now().toString()));
    }
}
