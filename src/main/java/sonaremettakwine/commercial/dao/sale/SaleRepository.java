package sonaremettakwine.commercial.dao.sale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.offre.Offre;
import sonaremettakwine.commercial.dao.proforma.Proforma;

import java.util.List;


@RepositoryRestResource
public interface SaleRepository extends JpaRepository<Sale,Long> {



    @Query("select s from Sale s where s.invoice=:invoice order by s.benefit.designation" )
    List<Sale> getSaleByInvoice(@RequestParam Invoice invoice);


    @Query("select s from Sale s where s.invoice=:invoice and s.benefit.tva=:taux order by s.id DESC")
    List<Sale> getSaleByInvoiceByTva(@RequestParam Invoice invoice, @RequestParam double taux);

    Sale getSaleById(Long id);
}
