package sonaremettakwine.commercial.dao.offre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import sonaremettakwine.commercial.dao.benifit.Tva;
import sonaremettakwine.commercial.dao.proforma.Proforma;


import java.util.List;

@RepositoryRestResource
public interface OffreRepository extends JpaRepository<Offre,Long> {
    @Query("select s from Offre s where s.proforma=:proforma order by s.id DESC")
    List<Offre> getOffreByProforma(@RequestParam Proforma proforma);


    @Query("select s from Offre s where s.proforma=:proforma and s.benefit.tva=:taux order by s.id DESC")
    List<Offre> getOffreByProformaByTva(@RequestParam Proforma proforma,@RequestParam double taux);

    Offre getOffreById(Long id);
}
