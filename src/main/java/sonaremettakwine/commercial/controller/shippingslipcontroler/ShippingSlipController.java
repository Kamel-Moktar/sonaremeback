package sonaremettakwine.commercial.controller.shippingslipcontroler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.shippingslip.ShippingSlip;
import sonaremettakwine.commercial.dao.shippingslipinvoice.ShippingSlipInvoice;
import sonaremettakwine.commercial.service.shippingslip.ShippingSlipService;


import java.util.List;

@RestController
@RequestMapping("/shippingslip")
public class ShippingSlipController {

    @Autowired
    ShippingSlipService shippingSlipService;

    @GetMapping("/all")
    public List<ShippingSlip> getAll() {
        return shippingSlipService.getAll();
    }

    @GetMapping("/byid/{id}")
    public ShippingSlip getShippingSlipById(@PathVariable Long id) {
        return shippingSlipService.getShippingSlipById(id);
    }


    @GetMapping("/invoicebyshippingslip/{id}")
    public List<ShippingSlipInvoice> invoiceByShippingSlip(@PathVariable Long id) {
        ShippingSlip shippingSlip=shippingSlipService.getShippingSlipById(id);
        return shippingSlipService.getInvoiceByShippingSlip(shippingSlip);
    }
    @GetMapping("/shippingslipinvoicebyid/{id}")
    public ShippingSlipInvoice ShippingSlipInvoiceById(@PathVariable Long id) {

        return shippingSlipService.getShippingSlipInvoiceById(id);
    }
    @PostMapping("/add")
    public ShippingSlip add(@RequestBody ShippingSlip shippingSlip) {
        return shippingSlipService.add(shippingSlip);
    }

    @PostMapping("/addinvoice")
    public ShippingSlipInvoice addInvoice(@RequestBody ShippingSlipInvoice shippingSlipInvoice) {
        return shippingSlipService.addInvoice(shippingSlipInvoice);
    }

    @PostMapping("/deleteinvoice")
    public ShippingSlipInvoice deleteInvoice(@RequestBody  ShippingSlipInvoice shippingSlipInvoice) {
        return shippingSlipService.deleteInvoice(shippingSlipInvoice);
    }

    @PostMapping("/accuse")
    public ShippingSlip accuse(@RequestBody ShippingSlip shippingSlip) {
        return shippingSlipService.accuse(shippingSlip);
    }

    @PostMapping("/delete")
    public ShippingSlip delete(@RequestBody ShippingSlip shippingSlip) {
        shippingSlipService.delete(shippingSlip);
        return shippingSlip;
    }

    @PutMapping("/update")
    public ShippingSlip update(@RequestBody ShippingSlip shippingSlip) {
        return shippingSlipService.update(shippingSlip);
    }

    @PostMapping("/updateinvoice")
    public ShippingSlipInvoice updateInvoice(@RequestBody ShippingSlipInvoice shippingSlipInvoice) {
        return shippingSlipService.updateShippingSlipInvoice(shippingSlipInvoice);
    }
}
