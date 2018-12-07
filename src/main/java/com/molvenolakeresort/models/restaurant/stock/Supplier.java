package com.molvenolakeresort.models.restaurant.stock;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Supplier")
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue
    private Long idSupplier;
    private String name;
    private String email;
    private String telephone;
    private String notes;

    public Supplier() {
    }

    public Long getId() {
        return idSupplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
