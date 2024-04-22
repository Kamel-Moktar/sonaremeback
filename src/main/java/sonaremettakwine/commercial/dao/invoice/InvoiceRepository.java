package sonaremettakwine.commercial.dao.invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

@RepositoryRestResource
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

    @Query("select i from Invoice i order by i.id DESC " ) //trier les enregistrement
    List<Invoice> getAllSortByID();

}
