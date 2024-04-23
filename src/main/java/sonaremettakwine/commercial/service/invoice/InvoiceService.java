package sonaremettakwine.commercial.service.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.invoice.InvoiceRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

        Calendar cal = new GregorianCalendar();
        cal.setTime(invoice.getDate());
        newInvoice.setNumber(nextInvoiceNumber(String.valueOf(cal.get(Calendar.YEAR))));


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

    public Long nextInvoiceNumber(String year)  {

        String d1="01/01/"+year;
        String d2="31/12/"+year;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);

        try {
            Date date1=formatter.parse(d1);
            Date date2=formatter.parse(d2);

            List<Invoice> invoices=invoiceRepository.getBetweenTowDateSortByNumber(date1,date2);

            if(!invoices.isEmpty()) return invoices.get(0).getNumber()+1;
            return 1L;

        } catch (ParseException e) {
            e.printStackTrace();
        }



        return 1L;
    }


}
