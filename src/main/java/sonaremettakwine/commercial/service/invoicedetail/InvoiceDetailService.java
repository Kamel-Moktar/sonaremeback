package sonaremettakwine.commercial.service.invoicedetail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.invoicedetail.InvoiceDetail;
import sonaremettakwine.commercial.dao.invoicedetail.InvoiceDetailRepository;

import java.util.List;

@Service
@Transactional
public class InvoiceDetailService {
    @Autowired
    InvoiceDetailRepository invoiceDetailRepository;

   public  List<InvoiceDetail> getAll() {
        return invoiceDetailRepository.findAll();
    }

    public InvoiceDetail getById(Long id) {
        return invoiceDetailRepository.getReferenceById(id);
    }


   public  List<InvoiceDetail> getByInvoice(Invoice invoice) {
        return invoiceDetailRepository.getAllByInvoice(invoice);
    }

   public  InvoiceDetail update(InvoiceDetail invoiceDetail) {
        InvoiceDetail invoiceDetail1 = getById(invoiceDetail.getId());
        invoiceDetail1.setPrice(invoiceDetail1.getPrice());
        invoiceDetail1.setInvoice(invoiceDetail1.getInvoice());
        invoiceDetail1.setObs(invoiceDetail1.getObs());
        return invoiceDetail;
    }


  public  InvoiceDetail delete(InvoiceDetail invoiceDetail) {
        invoiceDetailRepository.delete(invoiceDetail);
        return invoiceDetail;
    }

    public InvoiceDetail add(InvoiceDetail invoiceDetail) {
        return invoiceDetailRepository.save(invoiceDetail);
    }
}
