package com.molvenolakeresort.controllers.hotel;

import com.molvenolakeresort.models.hotel.Invoice;
import com.molvenolakeresort.repositories.hotel.InvoiceRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/invoice/")
public class InvoiceController {

    private InvoiceRepository invoiceRepository;

    public InvoiceController(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<Invoice> getAll() {
        return this.invoiceRepository.findAll();
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

    // tussen deze en volgende comment zijn tijdelijk - overigens werken de laatste twee niet!

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public void change(@PathVariable long id, @RequestBody String origin) {
        Invoice invoice = this.invoiceRepository.findById(id).get();
        invoice.setOrigin(origin);
        this.invoiceRepository.save(invoice);
    }

    @RequestMapping(value = "paid/{id2}", method = RequestMethod.PUT)
    public void toggleWatched(@PathVariable long id2) {
        Invoice invoice = this.invoiceRepository.getOne(id2);
        invoice.setPaid(!invoice.isPaid());
        this.invoiceRepository.save(invoice);
    }

    @RequestMapping(value = "{addAmount/id3}", method = RequestMethod.PUT)
    public void setAmount(@PathVariable long id3, @RequestBody String amount) {
        Invoice invoice = this.invoiceRepository.findById(id3).get();
        invoice.getInvoiceLines();
        this.invoiceRepository.save(invoice);
    }
    // tussen deze en voorgaande comment zijn tijdelijk ivm vullen h2database - overigens werken de laatste twee niet!

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
