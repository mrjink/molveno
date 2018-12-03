package com.molvenolakeresort.models.generic.security;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "Role")
@Table(name = "role")
@NamedQuery(name = "Role.findByName",
        query = "SELECT r FROM Role r WHERE r.name =:name ")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany(mappedBy = "roles")//(cascade = { CascadeType.MERGE, CascadeType.PERSIST })//
    private Collection<Profile> profiles;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void addProfile(Profile profile)
    {
        profile.addRole(this);
        if(this.profiles == null)
        {
            this.profiles = new ArrayList<>();
        }
    }

    public void removeProfile(Profile profile)
    {
        if(this.profiles != null)
        {
            this.profiles.remove(profile);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(Collection<Profile> profiles) {
        this.profiles = profiles;
    }
}
