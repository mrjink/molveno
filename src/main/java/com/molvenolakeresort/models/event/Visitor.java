package com.molvenolakeresort.models.event;

import javax.persistence.Entity;

@Entity
public class Visitor extends User {
    public Visitor(long id, String firstName, String middleName, String lastName, String email) {
        super(id, firstName, middleName, lastName, email);
    }
}
