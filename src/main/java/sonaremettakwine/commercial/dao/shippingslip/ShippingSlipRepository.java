package sonaremettakwine.commercial.dao.shippingslip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface ShippingSlipRepository extends JpaRepository<ShippingSlip,Long> {

    @Query("select s from ShippingSlip s order by s.id DESC " ) //trier les enregistrement
    List<ShippingSlip> getAllSortByID();

    @Query("select s from ShippingSlip s " +
            " where s.date between :d1  and :d2 " +
            " order by s.number DESC " ) //trier les enregistrement
    List<ShippingSlip> getBetweenTowDateSortByNumber(@RequestParam Date d1, @RequestParam Date d2);
}
