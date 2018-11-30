package com.molvenolakeresort.models.hotel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class InvoiceLine {

    @Id
    @GeneratedValue
    private long id;
    private String invoiceLine;
    private BigDecimal invoiceLineCost;

    public InvoiceLine() {}

    public String getInvoiceLine() {
        return invoiceLine;
    }

    public void setInvoiceLine(String invoiceLine) {
        this.invoiceLine = invoiceLine;
    }

    public BigDecimal getInvoiceLineCost() {
        return invoiceLineCost;
    }

    public void setInvoiceLineCost(BigDecimal invoiceLineCost) {
        this.invoiceLineCost = invoiceLineCost;
    }
}
