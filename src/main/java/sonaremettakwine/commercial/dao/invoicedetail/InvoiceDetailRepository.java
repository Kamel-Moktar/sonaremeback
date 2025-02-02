package sonaremettakwine.commercial.dao.invoicedetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;
import sonaremettakwine.commercial.dao.customer.Customer;
import sonaremettakwine.commercial.dao.inscription.Inscription;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.phase.Phase;
import sonaremettakwine.commercial.dao.sale.Sale;
import sonaremettakwine.commercial.dao.sale.Vente;
import sonaremettakwine.commercial.dao.session.Session;

import java.util.List;

@RepositoryRestResource
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {
    @Query("select  i from InvoiceDetail i " +
            " where i.invoice= :invoice " +
            " order by i.inscription.stagiaire.familyName,i.benefit.designation")
    List<InvoiceDetail> findByInvoiceOrderByInscriptionStagiaireFirstNameAndBenefitDesignation(@RequestParam Invoice invoice);

    @Query("select distinct i.inscription  from InvoiceDetail  i where i.invoice= :invoice  ")
    List<Inscription> getDistinctStagiaireByInvoice(@RequestParam Invoice invoice);


    List<InvoiceDetail> getAllByInvoiceAndInscription(Invoice invoice, Inscription inscription);

    @Query("select distinct i.inscription.session from InvoiceDetail i  where i.invoice= :invoice" )
    List<Session> getDistinctInscriptionSessionByInvoice(@RequestParam Invoice invoice);

    @Query("select distinct i.inscription from InvoiceDetail  i " +
            " where  i.phase=:phase" +
            " and i.invoice.customer=:customer ")
    List<Inscription> getDistinctInscriptionByPhaseAndInvoiceCustomer(@RequestParam  Phase phase,@RequestParam Customer customer);


    @Query("select i.inscription from InvoiceDetail i where i.inscription=:inscription and i.phase=:phase ")
    List<Inscription> getInscriptionByPhase(@RequestParam Inscription inscription,@RequestParam Phase phase);


    @Query("select i.phase from InvoiceDetail i " +
            " where i.invoice=:invoice " +
            "  and i.inscription=:inscription" +
            "  and i.phase is not null ")
    List<Phase> getPhaseBYInscriptionAndInvoice(@RequestParam Inscription inscription,@RequestParam Invoice invoice);

    @Query("Select new sonaremettakwine.commercial.dao.sale.Vente(i.invoice,i.benefit,count(i),sum(i.qte),i.price,i.phase.session)  from InvoiceDetail i" +

            " group by i.invoice,i.benefit,i.price,i.price,i.phase.session  ")

    List<Vente> getSaleOfInvoice(@RequestParam Invoice invoice);


}
