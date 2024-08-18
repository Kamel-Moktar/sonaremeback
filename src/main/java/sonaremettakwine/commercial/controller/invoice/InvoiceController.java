package sonaremettakwine.commercial.controller.invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @GetMapping("/debts")
    public List<Invoice> getDebts() {
        return invoiceService.getDebts();
    }

    @PostMapping("/debtsparam")
    public List<Invoice> getDebtsParam(@RequestBody Param param) {
        return invoiceService.getDebtsByNumberByCustomerByDate(param.number, param.shortName, param.date);
    }

    @PostMapping("/allparam")
    public List<Invoice> getAllParam(@RequestBody Param param) {
        return invoiceService.getAllByNumberByCustomerByDate(param.number, param.shortName, param.date);
    }

    @PostMapping("/turnover")
    public List<Invoice> getturnoverByNumberByCustomerByDate(@RequestBody Param param) {
        return invoiceService.getTurnoverByNumberByCustomerByDate(param.number, param.shortName, param.date);
    }


    @GetMapping("/byid/{id}")
    public Invoice getInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id);
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

    @PostMapping("/update")
    public Invoice update(@RequestBody Invoice invoice) {
        return invoiceService.update(invoice);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Param {
    String number;
    String shortName;
    String date;
}
