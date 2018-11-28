package com.molvenolakeresort.event;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public interface User {
    @Id
    @GeneratedValue
    long id = 0;
    String firstName = "";
    String middleName = "";
    String lastName = "";
    String email = "";
}
