package sonaremettakwine.commercial.dao.sale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;
import sonaremettakwine.commercial.dao.invoice.Invoice;

import java.util.List;


@RepositoryRestResource
public interface SaleRepository extends JpaRepository<Sale,Long> {



    @Query("select s from Sale s where s.invoice=:invoice")
    List<Sale> getSaleByInvoice(@RequestParam Invoice invoice);

}
