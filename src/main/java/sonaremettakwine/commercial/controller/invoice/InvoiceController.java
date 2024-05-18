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
    public List<Invoice> getDebtsParam(@RequestBody  Param param) {
        String number=!param.getNumber().equals("*") ?param.getNumber():"";
        String shortName=!param.getShortName().equals("*") ?param.getShortName():"";
        String date=!param.getDate().equals("*") ?param.getDate():"";

        return invoiceService.getDebtsByNumberByCustomerByDate(number,shortName,date);
    }
    @PostMapping("/allparam")
    public List<Invoice> getAllParam(@RequestBody  Param param) {
        String number=!param.getNumber().equals("*") ?param.getNumber():"";
        String shortName=!param.getShortName().equals("*") ?param.getShortName():"";
        String date=!param.getDate().equals("*") ?param.getDate():"";

        return invoiceService.getAllByNumberByCustomerByDate(number,shortName,date);
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
