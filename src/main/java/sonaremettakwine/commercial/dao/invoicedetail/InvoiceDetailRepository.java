package sonaremettakwine.commercial.dao.invoicedetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sonaremettakwine.commercial.dao.invoice.Invoice;

import java.util.List;

@RepositoryRestResource
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail,Long> {


    List<InvoiceDetail> getAllByInvoice(Invoice invoice);

}
