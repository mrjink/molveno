package com.molvenolakeresort.controllers.hotel;

import com.molvenolakeresort.models.hotel.Invoice;
import com.molvenolakeresort.repositories.hotel.InvoiceRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/invoices/")
public class InvoiceController {

    private InvoiceRepository invoiceRepository;

    public InvoiceController(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public JSONArray getAll() {
        JSONArray result = new JSONArray();
        for (Invoice invoice : this.invoiceRepository.findAll()) {
            JSONObject row = new JSONObject();
            row.put("ID", invoice.getId());
            row.put("Date", invoice.getInvoiceDate());
            row.put("Amount", invoice.getAmount());
            row.put("Paid",invoice.isPaid());
            row.put("Origin", invoice.getOrigin());
            result.add(row);
        }
        return  result;
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void create(@RequestBody Invoice invoice) {
        this.invoiceRepository.save(invoice);
    }

    @RequestMapping(value = "togglepaid/{billNumber}", method = RequestMethod.PUT)
    public void togglePaid(@PathVariable String billNumber) {
        for (Invoice invoice : this.invoiceRepository.findAll()) {
            if (invoice.getBillNumber().equals(billNumber)) {
                invoice.setPaid(!invoice.isPaid());
                this.invoiceRepository.save(invoice);
            }
        }
    }

    @RequestMapping(value = "delete/{billNumber}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String billNumber) {
        for (Invoice invoice : this.invoiceRepository.findAll()) {
            if (invoice.getBillNumber().equals(billNumber)) {
                this.invoiceRepository.delete(invoice);
            }
        }
    }

    @RequestMapping(value = "get/{billNumber}", method = RequestMethod.GET)
    public Iterable<Invoice> getInvoice(@PathVariable String billNumber) {
        List<Invoice> invoices = new ArrayList<>();
        for (Invoice invoice : this.invoiceRepository.findAll()) {
            if (invoice.getBillNumber().equals(billNumber)) {
                invoices.add(invoice);
            }
        }
        return invoices;
    }

}
