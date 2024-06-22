package sonaremettakwine.commercial.service.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.sale.Sale;
import sonaremettakwine.commercial.dao.sale.SaleRepository;
import sonaremettakwine.commercial.service.invoice.InvoiceService;

import java.util.List;

@Service
@Transactional
public class SaleService {
    @Autowired
    SaleRepository saleRepository;
    @Autowired
    InvoiceService invoiceService;


    public List<Sale> getSaleByInvoice(Invoice invoice) {
        return saleRepository.getSaleByInvoice(invoice);
    }

    public Sale add(Sale sale) {
        Invoice invoice = invoiceService.getInvoiceById(sale.getInvoice().getId());
        Sale sale1=saleRepository.save(sale);
        culeTotals(invoice);
        return sale1;
    }

    public void delete(Sale sale) {
        Invoice invoice = invoiceService.getInvoiceById(sale.getInvoice().getId());
        saleRepository.delete(sale);
        culeTotals(invoice);


    }

    public Sale getSaleById(Long id) {
        return saleRepository.getReferenceById(id);
    }

    public Sale update(Sale newSale) {
        Sale sale = getSaleById(newSale.getId());
        Invoice invoice = invoiceService.getInvoiceById(sale.getInvoice().getId());

        sale.setBenefit(newSale.getBenefit());
        sale.setNumber(newSale.getNumber());
        sale.setQuantity(newSale.getQuantity());
        sale.setPrice(newSale.getPrice());
        culeTotals(invoice);
        return sale;
    }


    public  void culeTotals(Invoice invoice) {

        List<Sale> sales = saleRepository.getSaleByInvoice(invoice);
        double ht = sales.stream().mapToDouble(e -> e.getPrice() *e.getNumber()* e.getQuantity()).sum();
        invoice.setAmountExcludingTax(ht);
        invoice.setAmountTax(ht * invoice.getTva());
        invoice.setAmountIncludingTax(ht * (invoice.getTva() + 1));
        invoice.setRemains(ht * (invoice.getTva() + 1));
    }

}
