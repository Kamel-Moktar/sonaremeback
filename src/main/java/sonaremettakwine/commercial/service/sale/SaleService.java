package sonaremettakwine.commercial.service.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.sale.Sale;
import sonaremettakwine.commercial.dao.sale.SaleRepository;
import sonaremettakwine.commercial.service.invoice.InvoiceService;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    SaleRepository saleRepository;
    @Autowired
    InvoiceService invoiceService;

   public  List<Sale> getSaleByInvoice(Invoice invoice){
        return saleRepository.getSaleByInvoice(invoice);
    }

    public Sale add(Sale sale){
       Invoice invoice=invoiceService.getInvoiceById(sale.getInvoice().getId());
       Double ht=sale.getPrice()*sale.getQuantity();
       Double invoiceHt=invoice.getAmountExcludingTax()+ht;
       invoice.setAmountExcludingTax(invoiceHt);
       invoice.setAmountTax(invoiceHt*0.9);
       invoice.setAmountIncludingTax(invoiceHt*1.09);

       return saleRepository.save(sale);
    }
    public void delete(Sale sale){
        Invoice invoice=invoiceService.getInvoiceById(sale.getInvoice().getId());
        Double ht=sale.getPrice()*sale.getQuantity();
        Double invoiceHt=invoice.getAmountExcludingTax()-ht;
        invoice.setAmountExcludingTax(invoiceHt);
        invoice.setAmountTax(invoiceHt*0.9);
        invoice.setAmountIncludingTax(invoiceHt*1.09);

         saleRepository.delete(sale);
    }
}
