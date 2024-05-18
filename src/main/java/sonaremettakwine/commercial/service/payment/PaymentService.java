package sonaremettakwine.commercial.service.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.encaissement.Encaissement;
import sonaremettakwine.commercial.dao.encaissement.EncaissementRepository;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.payment.Payment;
import sonaremettakwine.commercial.dao.payment.PaymentRepository;
import sonaremettakwine.commercial.service.invoice.InvoiceService;

import java.util.List;

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
        return paymentRepository.getReferenceById(id);
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
        return payment1;
    }


    public Encaissement addEncaissement(Encaissement encaissement) {
       Invoice invoice=invoiceService.getInvoiceById(encaissement.getInvoice().getId());
        Double remains=invoice.getRemains()-encaissement.getAmount();
        invoice.setRemains(remains);
        return encaissementRepository.save(encaissement);
    }

    public Encaissement deleteEncaissement(Encaissement encaissement) {
        Encaissement encaissement1 = encaissementRepository.getReferenceById(encaissement.getId());
        Double remains=encaissement1.getInvoice().getRemains()+encaissement.getAmount();
        encaissement1.getInvoice().setRemains(remains);
        encaissementRepository.delete(encaissement1);
        return encaissement1;
    }


}


