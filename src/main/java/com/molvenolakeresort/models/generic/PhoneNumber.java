package com.molvenolakeresort.models.generic;

import com.molvenolakeresort.models.generic.security.Profile;

import javax.persistence.*;

@Entity(name="Phonenumber")
@Table(name="phonenumber", uniqueConstraints = @UniqueConstraint(columnNames = {"value"}))
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String value;

    @OneToOne(mappedBy = "phoneNumber", cascade = CascadeType.ALL)
    private Profile profile;

    public PhoneNumber() {}

    public PhoneNumber(String value) {
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Profile getProfile() {
        return this.profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
