package sonaremettakwine.commercial.controller.pament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sonaremettakwine.commercial.dao.encaissement.Encaissement;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.payment.Payment;
import sonaremettakwine.commercial.service.payment.PaymentService;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("payment")
public class PaymentController {


    @Autowired
    PaymentService paymentService;

    @GetMapping("/all")
    public List<Payment> getAll() {
        return paymentService.getAll();
    }

    @GetMapping("/byid/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }


    @GetMapping("/encaissementbypayment/{id}")
    public List<Encaissement> invoiceByPayment(@PathVariable Long id) {
        Payment payment=paymentService.getPaymentById(id);
        return paymentService.getInvoiceByPayment(payment);
    }
    @GetMapping("/encaissementbyid/{id}")
    public Encaissement EncaissementById(@PathVariable Long id) {

        return paymentService.getEncaissementById(id);
    }
    @PostMapping("/add")
    public Payment add(@RequestBody Payment payment) {
        return paymentService.add(payment);
    }

    @PostMapping("/addencaissement")
    public Encaissement addEncaissement(@RequestBody Encaissement encaissement) {
        return paymentService.addEncaissement(encaissement);
    }

    @PostMapping("/deleteencaissement")
    public Encaissement deleteEncaissement(@RequestBody  Encaissement encaissement) {
        return paymentService.deleteEncaissement(encaissement);
    }


    @PostMapping("/delete")
    public Payment delete(@RequestBody Payment payment) {
        paymentService.delete(payment);
        return payment;
    }

    @GetMapping("/identification/{paymentId}")
    public Map<Long, Invoice> paymentIdentification(@PathVariable  Long paymentId){
        Payment payment=getPaymentById(paymentId);
        return paymentService.paymentIdentification(payment);
    }

    @PutMapping("/update")
    public Payment update(@RequestBody Payment payment) {
        return paymentService.update(payment);
    }


}

