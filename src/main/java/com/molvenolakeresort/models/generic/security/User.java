package com.molvenolakeresort.models.generic.security;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity(name = "User")
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = { "username", "passwordreseturi" }))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="username")
    private String username;

    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "passwordreseturi")
    private String passwordResetURI;

    @OneToOne(mappedBy = "user")
    @Nullable
    private Profile profile;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Unsafe method for storing password if the password is not hashed yet. Please check the 2nd overload attribute.
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Set password with security (used for storing passwords or parsing unhashed pwd retrievals).
     * @param password
     * @param isHashed if the password is already hashed set true, else set false.
     */
    public void setPassword(String password, boolean isHashed) {
        if(isHashed) {
            this.password = password;
        } else {
            this.password = PasswordEncryption.getHashedPassword(password);
        }
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPasswordResetURI() {
        return passwordResetURI;
    }

    public void setPasswordResetURI(String passwordResetURI) {
        this.passwordResetURI = passwordResetURI;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
