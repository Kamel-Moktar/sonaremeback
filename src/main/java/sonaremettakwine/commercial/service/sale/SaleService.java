package sonaremettakwine.commercial.service.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.benifit.Tva;
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
        Sale sale1 = saleRepository.save(sale);
        culeTotals(invoice);
        return sale1;
    }

    public List<Sale> getSaleByInvoiceByTva(Invoice invoice, double tva) {
        return saleRepository.getSaleByInvoiceByTva(invoice, tva);
    }

    public void delete(Sale sale) {
        Invoice invoice = invoiceService.getInvoiceById(sale.getInvoice().getId());
        saleRepository.delete(sale);
        culeTotals(invoice);


    }

    public Sale getSaleById(Long id) {
        return saleRepository.getSaleById(id);
    }

    public Sale update(Sale newSale) {
        Sale sale = getSaleById(newSale.getId());
        Invoice invoice = invoiceService.getInvoiceById(sale.getInvoice().getId());

        sale.setBenefit(newSale.getBenefit());
        sale.setNumber(newSale.getNumber());
        sale.setQuantity(newSale.getQuantity());
        sale.setPrice(newSale.getPrice());
        sale.setUnit(newSale.getUnit());
        culeTotals(invoice);

        return sale;
    }


    public Double getTotalTva(Invoice invoice, double taux) {
        List<Sale> sales = saleRepository.getSaleByInvoiceByTva(invoice, taux);
        if (invoice.getCustomer().isExemptFromTax() || invoice.getCustomer().isSameCompany()) return null;
        else return sales.stream().mapToDouble(
                e -> e.getPrice() * e.getNumber() * e.getQuantity() * e.getBenefit().getTva()).sum();

    }


    public void culeTotals(Invoice invoice) {

        List<Sale> sales = saleRepository.getSaleByInvoice(invoice);
        double ht = sales.stream().mapToDouble(e -> e.getPrice() * e.getNumber() * e.getQuantity()).sum();
        double tvaNormal = 0;
        double tvaReduite = 0;

        if (!(invoice.getCustomer().isExemptFromTax() || invoice.getCustomer().isSameCompany())) {
            tvaNormal = getTotalTva(invoice, Tva.NORMAL.getTaux().doubleValue());
            tvaReduite = getTotalTva(invoice, Tva.REDUITE.getTaux().doubleValue());
        }


        double tva = tvaNormal + tvaReduite;
        double ttc = tva + ht;

        invoice.setAmountExcludingTax(ht);
        invoice.setAmountTax(tva);
        invoice.setAmountIncludingTax(ttc);
        invoice.setRemains(ttc);


    }

}
