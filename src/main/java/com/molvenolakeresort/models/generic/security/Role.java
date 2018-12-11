package com.molvenolakeresort.models.generic.security;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String name;
    private boolean isEmployeeRole;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private Collection<User> users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

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

    public void setName(String name) {
        this.name = name;
    }

    public void addUser(User user) {
        user.setRole(this);
        if (this.users == null) {
            this.users = new ArrayList<>();
        }
    }

    public void removeUser(User user) {
        if (this.users != null) {
            this.users.remove(user);
        }
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

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }
}
