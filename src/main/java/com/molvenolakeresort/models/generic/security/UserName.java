package com.molvenolakeresort.models.generic.security;

import javax.persistence.*;

@Entity(name="Username")
@Table(name="username", uniqueConstraints = @UniqueConstraint(columnNames = {"value"}))
public class UserName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String value;

    @OneToOne(mappedBy = "username", cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public UserName() {}

    public UserName(String value) {
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        profile.setUsername(this);
        this.profile = profile;
    }
}