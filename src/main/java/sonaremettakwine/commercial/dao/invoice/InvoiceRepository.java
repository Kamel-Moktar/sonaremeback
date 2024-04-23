package sonaremettakwine.commercial.dao.invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

    @Query("select i from Invoice i order by i.id DESC " ) //trier les enregistrement
    List<Invoice> getAllSortByID();

    @Query("select i from Invoice i " +
            " where i.date between :d1  and :d2 " +
            " order by i.number DESC " ) //trier les enregistrement
    List<Invoice> getBetweenTowDateSortByNumber(@RequestParam Date d1, @RequestParam Date d2);


}
