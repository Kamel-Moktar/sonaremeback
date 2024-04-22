package sonaremettakwine.commercial.service.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.invoice.InvoiceRepository;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;



    public List<Invoice> getAll(){

        return invoiceRepository.getAllSortByID();

    }

    Invoice getInvoiceById(Long id){
        return invoiceRepository.getReferenceById(id);
    }



    public Invoice add(Invoice invoice){
        Invoice newInvoice=new Invoice();
        newInvoice.setCustomer(invoice.getCustomer());
        newInvoice.setReference(invoice.getReference());
        newInvoice.setObject(invoice.getObject());
        newInvoice.setDate(invoice.getDate());
        newInvoice.setNumber(invoice.getNumber());


        return invoiceRepository.save(newInvoice);
    }

    public void delete(Invoice invoice){ invoiceRepository.delete(invoice);  }

    public Invoice update(Invoice invoice){
        Invoice invoice1=getInvoiceById(invoice.getId());
        invoice1.setDate(invoice.getDate());
        invoice1.setObject(invoice.getObject());
        invoice1.setReference(invoice.getReference());
        invoice1.setCustomer(invoice.getCustomer());
        return invoice1;
    }


}
