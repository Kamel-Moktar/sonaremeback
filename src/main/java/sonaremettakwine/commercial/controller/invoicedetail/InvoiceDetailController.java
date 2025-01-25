package sonaremettakwine.commercial.controller.invoicedetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.invoicedetail.InvoiceDetail;
import sonaremettakwine.commercial.service.invoice.InvoiceService;
import sonaremettakwine.commercial.service.invoicedetail.InvoiceDetailService;

import java.util.List;

@RestController
@RequestMapping("invoice-detail")
public class InvoiceDetailController {

    @Autowired
    InvoiceDetailService invoiceDetailService;
    @Autowired
    InvoiceService invoiceService;


    @GetMapping("/")
    public List<InvoiceDetail> getAll() {
        return invoiceDetailService.getAll();
    }

    @GetMapping("/{id}")
   public  InvoiceDetail getById(@PathVariable  Long id) {
        return invoiceDetailService.getById(id);
    }

    @DeleteMapping("/{id}")
    public  void delete(@PathVariable Long id){
        InvoiceDetail invoiceDetail=invoiceDetailService.getById(id);
        invoiceDetailService.delete(invoiceDetail);
    }
    @GetMapping("/invoice/{id}")
    public List<InvoiceDetail> getByInvoice(@PathVariable Long id){
        Invoice invoice=invoiceService.getInvoiceById(id);
        return invoiceDetailService.getByInvoice(invoice);
    }

    @PutMapping("/")
    public InvoiceDetail update(@RequestBody InvoiceDetail invoiceDetail){
        return invoiceDetailService.update(invoiceDetail);
    }

    @PostMapping("/")
    public InvoiceDetail add(@RequestBody  InvoiceDetail invoiceDetail){
        return invoiceDetailService.add(invoiceDetail);

    }

}
