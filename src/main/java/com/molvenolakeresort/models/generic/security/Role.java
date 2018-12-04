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
    private boolean isEmployeeRole;

    @OneToMany(mappedBy = "role")//(cascade = { CascadeType.MERGE, CascadeType.PERSIST })//
    private Collection<User> users;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(String name, boolean isEmployeeRole) {
        this.name = name;
        this.isEmployeeRole = isEmployeeRole;
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

    public void addUser(User user)
    {
        user.setRole(this);
        if(this.users == null)
        {
            this.users = new ArrayList<>();
        }
    }

    public void removeUser(User user)
    {
        if(this.users != null)
        {
            this.users.remove(user);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<User> getUsers() {
        return this.users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public boolean isEmployeeRole() {
        return isEmployeeRole;
    }

    public void setEmployeeRole(boolean employeeRole) {
        isEmployeeRole = employeeRole;
    }
}
