package com.molvenolakeresort.models.restaurant.stock;


import javax.persistence.*;
import java.util.List;

@Entity(name = "Supplier")
@Table(name = "supplier")
public class Supplier {
    @Id @GeneratedValue
    private Long idSupplier;
    private String name;
    private String email;
    private String telephone;
    private String notes;

    @OneToMany(
        mappedBy = "supplier",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<SupplyOrderSupplierIngredient> supplyOrderSupplierIngredients;

    @OneToMany(
            mappedBy = "supplier",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SupplierIngredient> supplierIngredients;

    public Supplier() {
    }

    public Long getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Long idSupplier) {
        this.idSupplier = idSupplier;
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

    public List<SupplyOrderSupplierIngredient> getSupplyOrderSupplierIngredients() {
        return supplyOrderSupplierIngredients;
    }

    public void setSupplyOrderSupplierIngredients(List<SupplyOrderSupplierIngredient> supplyOrderSupplierIngredients) {
        this.supplyOrderSupplierIngredients = supplyOrderSupplierIngredients;
    }

    public List<SupplierIngredient> getSupplierIngredients() {
        return supplierIngredients;
    }

    public void setSupplierIngredients(List<SupplierIngredient> supplierIngredients) {
        this.supplierIngredients = supplierIngredients;
    }
}
