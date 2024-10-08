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

    @Query("select i from Invoice  i " +
            " where i.remains<>0  " +
            " and not i.customer.sameCompany" +
            " order by i.date")
    List<Invoice> debts();


    @Query("select i from Invoice  i where i.remains<>0 " +
            " and format(i.date ,'dd/mm/yyyy') like '%'||:date||'%'" +
            " and upper(i.customer.shortName) like '%'||upper(:shortName)||'%'" +
            " and cast (i.number as string) like '%'||:number||'%' " +
            " and not i.customer.sameCompany" +
            " order by i.date")
    List<Invoice> getDebtsByNumberByCustomerByDate(@RequestParam  String number,@RequestParam String shortName,@RequestParam String date);

    @Query("select i from Invoice  i " +
            " where format(i.date ,'dd/mm/yyyy') like '%'||:date||'%'" +
            " and upper(i.customer.shortName) like '%'||upper(:shortName)||'%'" +
            " and cast (i.number as string) like '%'||:number||'%' " +
            " order by i.number DESC")
    List<Invoice> getAllByNumberByCustomerByDate(@RequestParam  String number,@RequestParam String shortName,@RequestParam String date);


    @Query("select i from Invoice  i " +
            " where format(i.date ,'dd/mm/yyyy') like '%'||:date||'%'" +
            " and upper(i.customer.shortName) like '%'||upper(:shortName)||'%'" +
            " and cast (i.number as string) like '%'||:number||'%' " +
            " and not i.customer.sameCompany " +
            " order by i.number DESC")
    List<Invoice> getTurnoverByNumberByCustomerByDate(@RequestParam  String number,@RequestParam String shortName,@RequestParam String date);

}
