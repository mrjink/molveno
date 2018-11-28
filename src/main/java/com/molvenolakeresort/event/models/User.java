package com.molvenolakeresort.event.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public interface User {
    @Id
    @GeneratedValue
    long id = 0;
    String firstName = "";
    String middleName = "";
    String lastName = "";
    String email = "";
}
