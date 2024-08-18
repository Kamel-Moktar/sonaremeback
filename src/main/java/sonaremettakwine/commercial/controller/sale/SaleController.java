package sonaremettakwine.commercial.controller.sale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.proforma.Proforma;
import sonaremettakwine.commercial.dao.sale.Sale;
import sonaremettakwine.commercial.service.invoice.InvoiceService;
import sonaremettakwine.commercial.service.sale.SaleService;

import java.util.List;
@RestController
@RequestMapping("/sale")

public class SaleController {

    @Autowired
    SaleService saleService;
    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/byinvoice/{id}")
    List<Sale> getSaleByInvoice(@PathVariable Long id){
        Invoice invoice= invoiceService.getInvoiceById(id);
        return saleService.getSaleByInvoice(invoice);
    }

    @PostMapping("/byinvoicebytva")
    Double getOffreByProformaByTva(@RequestBody Param param){
        Invoice invoice= invoiceService.getInvoiceById(param.getInvoiceId());
        return saleService.getTotalTva(invoice,param.getTauxTva());
    }

    @GetMapping("/byid/{id}")
    Sale getSaleById(@PathVariable Long id){

        return saleService.getSaleById(id);
    }
    @PostMapping("/add")
    Sale add(@RequestBody Sale sale){
        return saleService.add(sale);
    }

    @PostMapping("/delete")
    Sale delete(@RequestBody Sale sale){
         saleService.delete(sale);
         return sale;
    }

    @PostMapping("/update")
    Sale update(@RequestBody  Sale sale){
       return  saleService.update(sale) ;
    }

}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Param {
    Long invoiceId;
    double tauxTva;
}
