package sonaremettakwine.commercial.service.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import sonaremettakwine.commercial.dao.customer.Customer;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.invoice.InvoiceRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;


    public List<Invoice> getAll() {

        return invoiceRepository.getAllSortByID();

    }


    public List<Invoice> getDebts(){
       return  invoiceRepository.getDebts();
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.getInvoiceById(id);
    }



    public List<Invoice> getDebtsByNumberByCustomerByDate(String number, String shortName, String date) {
        return invoiceRepository.getDebtsByNumberByCustomerByDate(number, shortName, date);
    }
    public List<Invoice> getAllByNumberByCustomerByDate(String number, String shortName, String date) {
        return invoiceRepository.getAllByNumberByCustomerByDate(number, shortName, date);
    }


    public List<Invoice> getTurnoverByNumberByCustomerByDate(String number, String shortName, String date) {
        return invoiceRepository.getTurnoverByNumberByCustomerByDate(number, shortName, date);
    }
    public Invoice add(Invoice invoice) {
        Invoice newInvoice = new Invoice();
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

    public void delete(Invoice invoice) {
        invoiceRepository.delete(invoice);
    }

    public Invoice update(Invoice invoice) {
        Invoice invoice1 = getInvoiceById(invoice.getId());
        invoice1.setDate(invoice.getDate());
        invoice1.setObject(invoice.getObject());
        invoice1.setReference(invoice.getReference());
        invoice1.setCustomer(invoice.getCustomer());

        return invoice1;
    }


    public Invoice updateRemains(Long id, Double remains) {
        Invoice invoice1 = getInvoiceById(id);
        invoice1.setRemains(remains);

        return invoice1;
    }


    public Long nextInvoiceNumber(String year) {
       Long y= Long.parseLong(year);
        String nextYear=(y+1)+"";
        String d1 = "01/01/" + year;
        String d2 = "01/01/" + nextYear;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
        try {
            Date date1 = formatter.parse(d1);
            Date date2 = formatter.parse(d2);

            List<Invoice> invoices = invoiceRepository.getBetweenTowDateSortByNumber(date1, date2);

            if (!invoices.isEmpty()) return invoices.get(0).getNumber() + 1;
            return 1L;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 1L;
    }


    public List<Customer> getCustomerWithDebts(){
        return invoiceRepository.getCustomerWithDebts();
    }


    public List<Invoice> getDebsByCustomer(Customer customer){
        return invoiceRepository.getDebtsByCustomer(customer);
    }


}
