package com.molvenolakeresort.models.hotel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private int id;
    private String billNumber;
    private String payType;


    @OneToOne(mappedBy = "invoice")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn
    private Invoice parentInvoice;

    @OneToMany(mappedBy = "parentInvoice")
    private Set<Invoice> childInvoices = new HashSet<>();

    private boolean isPaid;
    private String deposit;
    private boolean isDepositPaid;

    public Invoice() {
    }

    public int getId() {
        return id;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public boolean isDepositPaid() {
        return isDepositPaid;
    }

    public void setDepositPaid(boolean depositPaid) {
        isDepositPaid = depositPaid;
    }

    public Invoice getParentInvoice() {
        return parentInvoice;
    }

    public void setParentInvoice(Invoice parentInvoice) {
        this.parentInvoice = parentInvoice;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Set<Invoice> getChildInvoices() {
        return childInvoices;
    }

    public void setChildInvoices(Set<Invoice> childInvoices) {
        this.childInvoices = childInvoices;
    }
}
