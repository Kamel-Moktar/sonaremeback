package sonaremettakwine.commercial.dao.stagiaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;
import sonaremettakwine.commercial.dao.shippingslip.ShippingSlip;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface StagiaireRepository extends JpaRepository<Stagiaire,Long> {

    @Query("select s from Stagiaire s " +

            " order by s.familyName " ) //trier les enregistrement
    List<Stagiaire> getAllSortByName();
}
