package sonaremettakwine.commercial.service.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.customer.Customer;
import sonaremettakwine.commercial.dao.encaissement.Encaissement;
import sonaremettakwine.commercial.dao.encaissement.EncaissementRepository;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.payment.Payment;
import sonaremettakwine.commercial.dao.payment.PaymentRepository;
import sonaremettakwine.commercial.service.invoice.InvoiceService;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    EncaissementRepository encaissementRepository;

    @Autowired
    InvoiceService invoiceService;

    public List<Payment> getAll() {
        return paymentRepository.getAllSortByID();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.getPaymentById(id);
    }

    public List<Encaissement> getInvoiceByPayment(Payment payment) {
        return encaissementRepository.getEncaissementByPayment(payment);
    }

    public Encaissement getEncaissementById(Long encaissementId) {
        return encaissementRepository.getReferenceById(encaissementId);
    }


    public Payment add(Payment payment) {
        return paymentRepository.save(payment);
    }


    public void delete(Payment payment) {
        paymentRepository.delete(payment);
    }

    public Payment update(Payment payment) {
        Payment payment1 = getPaymentById(payment.getId());
        payment1.setDate(payment.getDate());
        payment1.setAmount(payment.getAmount());
        return payment1;
    }


    public Encaissement addEncaissement(Encaissement encaissement) {
        Invoice invoice = invoiceService.getInvoiceById(encaissement.getInvoice().getId());
        Double remains = invoice.getRemains() - encaissement.getAmount();
        invoice.setRemains(remains);
        return encaissementRepository.save(encaissement);
    }

    public Encaissement deleteEncaissement(Encaissement encaissement) {
        Encaissement encaissement1 = encaissementRepository.getReferenceById(encaissement.getId());
        Double remains = encaissement1.getInvoice().getRemains() + encaissement.getAmount();
        encaissement1.getInvoice().setRemains(remains);
        encaissementRepository.delete(encaissement1);
        return encaissement1;
    }


    public Map<Long, Invoice> paymentIdentification(Payment payment) {

        Map<Long, Invoice> invoices = new HashMap<Long, Invoice>();
        List<Customer> customers = invoiceService.getCustomerWithDebts();
        for (Customer c : customers) {
            List<Invoice> debts = invoiceService.getDebsByCustomer(c);
            double total = debts.stream().mapToDouble(Invoice::getRemains).sum();
            Long key = 0L;

            if (total >= payment.getAmount()) {
                for (int i = 0; i < debts.size(); i++) {

                    Double cumul = debts.get(i).getRemains();
//                    System.out.println("pppppp:"+total);
                    if (cumul-payment.getAmount()<0.009) {
                        invoices.put(key, debts.get(i));
                        key++;
                    } else if (cumul < payment.getAmount()) {
                        List<Invoice> invoiceList = new LinkedList<Invoice>();
                        invoiceList.add(debts.get(i));
                        for (int j = i + 1; j < debts.size(); j++) {
                            cumul = cumul + debts.get(j).getRemains();
                            invoiceList.add(debts.get(j));
                            if (cumul.equals(payment.getAmount())) {
                                for (Invoice inv : invoiceList) invoices.put(key, inv);
                                key++;
                            } else if (cumul > payment.getAmount()) break;
                        }
                    }
                    if (cumul > payment.getAmount()) break;
                }
            }
        }
        return invoices;
    }
}


