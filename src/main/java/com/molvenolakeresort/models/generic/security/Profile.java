package com.molvenolakeresort.models.generic.security;

import com.molvenolakeresort.models.generic.PhoneNumber;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "Profile")
@Table(name = "profile", uniqueConstraints = @UniqueConstraint(columnNames = { "username_id", "phonenumber_id" }))
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Nullable
    private String firstName;
    @Nullable
    private String middleName;
    @Nullable
    private String lastName;

    //@ManyToMany(fetch=FetchType.EAGER, mappedBy = "profiles")
    @ManyToMany
    @JoinTable(name = "profile_role",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "username_id")
    @Nullable
    private UserName username;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "phonenumber_id")
    @Nullable
    private PhoneNumber phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "address_id")
    @Nullable
    private PhoneNumber address;

    private String password;

    private String passwordResetURI;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "guestinformation_id")
    @Nullable
    private GuestInformation guestInformation;

    public Profile() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Nullable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@Nullable String firstName) {
        this.firstName = firstName;
    }

    @Nullable
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(@Nullable String middleName) {
        this.middleName = middleName;
    }

    @Nullable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@Nullable String lastName) {
        this.lastName = lastName;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role)
    {
        if(this.roles == null)
        {
            this.roles = new ArrayList<>();
        }
        this.roles.add(role);
    }

    public void removeRole(Role role)
    {
        if(this.roles != null)
        {
            this.roles.remove(role);
        }
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Nullable
    public UserName getUsername() {
        return username;
    }

    public void setUsername(@Nullable UserName username) {
        this.username = username;
    }

    @Nullable
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Nullable PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Nullable
    public PhoneNumber getAddress() {
        return address;
    }

    public void setAddress(@Nullable PhoneNumber address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordResetURI() {
        return passwordResetURI;
    }

    public void setPasswordResetURI(String passwordResetURI) {
        this.passwordResetURI = passwordResetURI;
    }

    @Nullable
    public GuestInformation getGuestInformation() {
        return guestInformation;
    }

    public void setGuestInformation(@Nullable GuestInformation guestInformation) {
        this.guestInformation = guestInformation;
    }
}
