package com.molvenolakeresort.models.generic.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.molvenolakeresort.security.PasswordEncryption;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="username", unique = true)
    private String username;

    private String password;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "passwordreseturi", unique = true)
    private String passwordResetURI;

    @OneToOne(mappedBy = "user")
    @Nullable
    @JsonIgnore
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

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

        list.add(new SimpleGrantedAuthority(role.getName()));
        if(role.getPrivileges() != null)
        for(Privilege p : role.getPrivileges())
        {
            list.add(new SimpleGrantedAuthority(p.getName()));
        }

        return list;
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
