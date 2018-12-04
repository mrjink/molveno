package com.molvenolakeresort.models.generic.security;

import com.molvenolakeresort.models.generic.Gender;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity(name = "Profile")
@Table(name = "profile", uniqueConstraints = @UniqueConstraint(columnNames = { "email", "phonenumber" }))
@NamedQuery(name = "Profile.findByEmail",
        query = "SELECT p FROM Profile p WHERE p.email =:email ")
@NamedQuery(name = "Profile.findByPhoneNumber",
        query = "SELECT p FROM Profile p WHERE p.phoneNumber =:phonenumber ")
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

    @Nullable
    @Column(name = "email")
    private String email;

    @Nullable
    @Column(name = "phonenumber")
    private String phoneNumber;

    @Nullable
    @Column(name = "isvisitor")
    private boolean isVisitor;

    @Enumerated(value = EnumType.STRING)
    private Gender gender = Gender.UNKNOWN;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "guestinformation_id")
    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "guestinformation_id")
    @Nullable
    private GuestInformation guestInformation;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "user_id")
    @Nullable
    private User user;

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

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Nullable String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Nullable
    public GuestInformation getGuestInformation() {
        return guestInformation;
    }

    public void setGuestInformation(@Nullable GuestInformation guestInformation) {
        this.guestInformation = guestInformation;
    }

    public boolean isVisitor() {
        return isVisitor;
    }

    public void setVisitor(boolean visitor) {
        isVisitor = visitor;
    }

    @Nullable
    public User getUser() {
        return user;
    }

    public void setUser(@Nullable User user) {
        this.user = user;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
