package com.molvenolakeresort.models.generic;

import com.molvenolakeresort.models.generic.security.Profile;
import com.molvenolakeresort.models.generic.security.Role;
import com.molvenolakeresort.models.generic.security.User;
import com.molvenolakeresort.security.PasswordEncryption;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTest {
    private final String username;
    private final String password;
    private final String passwordResetURI;
    private final Role role;
    private final Profile profile;

    User unsecureUser;

    public UserTest() {
        this.username = "test";
        this.password = "pwd";
        this.passwordResetURI = "reseturi";
        this.role = new Role();
        this.profile = new Profile();
    }

    @Test
    public void testGetterSetters() {
        unsecureUser = new User();
        unsecureUser.setUsername(this.username);
        unsecureUser.setPassword(this.password);
        unsecureUser.setPasswordResetURI(this.passwordResetURI);
        unsecureUser.setRole(this.role);
        unsecureUser.setProfile(this.profile);


        assertSame(this.username, unsecureUser.getUsername());
        assertSame(this.password, unsecureUser.getPassword());
        assertSame(this.passwordResetURI, unsecureUser.getPasswordResetURI());
        assertNotNull(unsecureUser.getRole());
        assertNotNull(unsecureUser.getProfile());

        assertEquals("test", unsecureUser.getUsername());
        assertEquals("pwd", unsecureUser.getPassword());
        assertEquals("reseturi", unsecureUser.getPasswordResetURI());
    }

    @Test
    public void testSecurity() {
        User secureUser = new User();
        secureUser.setUsername(this.username);
        secureUser.setPassword(this.password);
        secureUser.setPasswordResetURI(this.passwordResetURI);
        secureUser.setRole(this.role);
        secureUser.setProfile(this.profile);

        secureUser.setPassword("pwd", false);
        secureUser.setPasswordResetURI(PasswordEncryption.getPasswordRecoveryUri(secureUser));

        assertNotNull(secureUser.getPassword());
        assertNotEquals("pwd", secureUser.getPassword());
        assertTrue(PasswordEncryption.isMatchingPassword("pwd", secureUser.getPassword()));
        assertNotNull(secureUser.getPasswordResetURI());
        assertNotEquals(PasswordEncryption.getPasswordRecoveryUri(secureUser), secureUser.getPasswordResetURI());
    }
}
