package sonaremettakwine.commercial.dao.proforma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Date;
import java.util.List;
@RepositoryRestResource
public interface ProformaRepository extends JpaRepository<Proforma, Long> {

    @Query("select i from Proforma i order by i.id DESC " ) //trier les enregistrement
    List<Proforma> getAllSortByID();

    @Query("select i from Proforma i " +
            " where i.date between :d1  and :d2 " +
            " order by i.number DESC " ) //trier les enregistrement
    List<Proforma> getBetweenTowDateSortByNumber(@RequestParam Date d1, @RequestParam Date d2);


    @Query("select i from Proforma  i where i.remains<>0  order by i.date")
    List<Proforma> debts();


    @Query("select i from Proforma  i where i.remains<>0 " +
            " and format(i.date ,'dd/mm/yyyy') like '%'||:date||'%'" +
            " and upper(i.customer.shortName) like '%'||upper(:shortName)||'%'" +
            " and cast (i.number as string) like '%'||:number||'%' " +
            " order by i.date")
    List<Proforma> getDebtsByNumberByCustomerByDate(@RequestParam  String number,@RequestParam String shortName,@RequestParam String date);

    @Query("select i from Proforma  i " +
            " where format(i.date ,'dd/mm/yyyy') like '%'||:date||'%'" +
            " and upper(i.customer.shortName) like '%'||upper(:shortName)||'%'" +
            " and cast (i.number as string) like '%'||:number||'%' " +
            " order by i.number DESC")
    List<Proforma> getAllByNumberByCustomerByDate(@RequestParam  String number,@RequestParam String shortName,@RequestParam String date);

    Proforma getProformaById(Long id);
}
