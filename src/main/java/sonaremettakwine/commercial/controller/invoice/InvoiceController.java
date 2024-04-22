package sonaremettakwine.commercial.controller.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.service.invoice.InvoiceService;


import java.util.List;
@RestController
@RequestMapping("/invoice")
public class InvoiceController {



    @Autowired
    InvoiceService invoiceService;


    @GetMapping("/all")
    public List<Invoice> getAll() {
        return invoiceService.getAll();
    }


    @PostMapping("/add")
    public Invoice add(@RequestBody Invoice invoice) {

        return invoiceService.add(invoice);

    }

    @PostMapping("/delete")
    public Invoice delete(@RequestBody Invoice invoice) {
        invoiceService.delete(invoice);
        return invoice;
    }

    @PutMapping("/update")
    public Invoice update(@RequestBody Invoice invoice) {
        return invoiceService.update(invoice);
    }
}
