package com.molvenolakeresort.models.generic;


import javax.persistence.*;
import java.util.Collection;

@Entity(name = "Country")
@Table(name = "country", uniqueConstraints = @UniqueConstraint(columnNames = { "name" }))
@NamedQuery(name = "Country.findByName",
        query = "SELECT c FROM Country c WHERE c.name =:name ")
@NamedQuery(name = "Country.findByCode",
        query = "SELECT c FROM Country c WHERE c.code =:code ")
@NamedQuery(name = "Country.exists",
        query = "SELECT CASE WHEN COUNT(c) > 0 THEN TRUE ELSE FALSE END FROM Country c WHERE c.name =:name OR c.code =:code ")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String code;

    @OneToMany(cascade = CascadeType.ALL)
    @OrderColumn
    private Collection<Address> address;

    public Country(){}

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Collection<Address> getAddress() {
        return address;
    }

    public void setAddress(Collection<Address> address) {
        this.address = address;
    }
}