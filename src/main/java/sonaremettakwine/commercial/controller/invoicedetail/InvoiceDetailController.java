package sonaremettakwine.commercial.controller.invoicedetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sonaremettakwine.commercial.dao.inscription.Inscription;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.invoicedetail.InvoiceDetail;
import sonaremettakwine.commercial.dao.phase.Phase;
import sonaremettakwine.commercial.dao.session.Session;
import sonaremettakwine.commercial.service.inscription.InscriptionService;
import sonaremettakwine.commercial.service.invoice.InvoiceService;
import sonaremettakwine.commercial.service.invoicedetail.InvoiceDetailService;

import java.util.List;

@RestController
@RequestMapping("invoice-detail")
public class InvoiceDetailController {

    @Autowired
    InvoiceDetailService invoiceDetailService;
    @Autowired
    InvoiceService invoiceService;

    @Autowired
    InscriptionService inscriptionService;


    @GetMapping("/")
    public List<InvoiceDetail> getAll() {
        return invoiceDetailService.getAll();
    }

    @GetMapping("/{id}")
    public InvoiceDetail getById(@PathVariable Long id) {
        return invoiceDetailService.getById(id);
    }

    @DeleteMapping("/{id}")
    public InvoiceDetail delete(@PathVariable Long id) {
        InvoiceDetail invoiceDetail = invoiceDetailService.getById(id);
        return invoiceDetailService.delete(invoiceDetail);
    }

    @DeleteMapping("/{id}/{id2}")
    public InvoiceDetail deleteAll(@PathVariable Long id, @PathVariable Long id2) {
        Invoice invoice = invoiceService.getInvoiceById(id2);
        Inscription inscription = inscriptionService.getInscriptionById(id);
        return invoiceDetailService.deleteAll(inscription, invoice);
    }

    @GetMapping("/invoice/{id}")
    public List<InvoiceDetail> getByInvoice(@PathVariable Long id) {
        Invoice invoice = invoiceService.getInvoiceById(id);
        return invoiceDetailService.getByInvoice(invoice);
    }

    @GetMapping("/inscription/{id}")
    public List<Inscription> getInscriptionByInvoice(@PathVariable Long id) {
        Invoice invoice = invoiceService.getInvoiceById(id);
        return invoiceDetailService.getDistinctInscriptionByInvoice(invoice);
    }

    @GetMapping("/session/{id}")
    public List<Session> getDistinctSessionByInvoice(@PathVariable Long id) {
        Invoice invoice = invoiceService.getInvoiceById(id);
        return invoiceDetailService.getDistinctSessionByInvoice(invoice);
    }

    @PutMapping("/")
    public InvoiceDetail update(@RequestBody InvoiceDetail invoiceDetail) {
        return invoiceDetailService.update(invoiceDetail);
    }

    @PostMapping("/")
    public void add(@RequestBody Param param) {

        for (Phase ph : param.getPhases()) {
            for(Inscription ins: param.getInscriptions()){
                InvoiceDetail invoiceDetail = new InvoiceDetail();
                invoiceDetail.setInvoice(param.invoice);
                invoiceDetail.setPhase(ph);
                invoiceDetail.setInscription(ins);
                invoiceDetailService.add(invoiceDetail);
            }
        }


    }


    @PostMapping("/add")
    public InvoiceDetail add1(@RequestBody InvoiceDetail invoiceDetail) {
        return invoiceDetailService.add1(invoiceDetail);

    }


    @PostMapping("/isbilled")
    public void updateIsBilled(@RequestBody InvoiceDetail invoiceDetail) {
        invoiceDetailService.updatePhaseIsBilled(invoiceDetail);

    }

    @GetMapping("/phase/{id1}/{id2}")
    public List<Phase> getPhase(@PathVariable Long id1, @PathVariable Long id2) {
        Invoice invoice = invoiceService.getInvoiceById(id2);
        Inscription inscription = inscriptionService.getInscriptionById(id1);
        return invoiceDetailService.getPhase(inscription, invoice);
    }


    @PostMapping("/refresh")
    public void refresh(@RequestBody InvoiceDetail invoiceDetail) {
        invoiceDetailService.refresh(invoiceDetail);
    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Param {
    List<Phase> phases;
    List<Inscription> inscriptions;
    Invoice invoice;
}
