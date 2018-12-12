package com.molvenolakeresort.models.hotel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private int id;
    private String billNumber;
    private String payType;
    private LocalDateTime createdDate;
    private LocalDateTime paidDate;
    private String origin;

    private boolean isPaid;
    private String deposit;
    private LocalDateTime depositPaidDate;
    private boolean isDepositPaid;

    @OneToMany
    @JoinColumn
    private List<InvoiceLine> invoiceLines;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Reservation reservation;


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

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public LocalDateTime getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(LocalDateTime paidDate) {
        this.paidDate = paidDate;
    }

    public LocalDateTime getDepositPaidDate() {
        return depositPaidDate;
    }

    public void setDepositPaidDate(LocalDateTime depositPaidDate) {
        this.depositPaidDate = depositPaidDate;
    }

    public List<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }
}
