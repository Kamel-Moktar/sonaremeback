package sonaremettakwine.commercial.dao.inscription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;
import sonaremettakwine.commercial.dao.customer.Customer;
import sonaremettakwine.commercial.dao.session.Session;
import sonaremettakwine.commercial.dao.stagiaire.Stagiaire;

import java.util.List;

@RepositoryRestResource
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

    @Query("select i from Inscription i " +
            " where i.session=:session  " +
            " order by i.stagiaire.familyName")
    List<Inscription> getAllBySession(@RequestParam Session session);

    @Query("select i from Inscription i " +
            " where i.stagiaire=:stagiaire  " +
            " order by i.session.startDate desc ")
    List<Inscription> getAllByStagiaire(@RequestParam Stagiaire stagiaire);

    List<Inscription> getBySessionAndStagiaireCustomerAndArriveDateNotNullOrderByStagiaireFirstName(Session sessions,Customer customer);

    @Query("select distinct i.session  from Inscription i " +
            " where i.stagiaire.customer=:customer  " +
            " order by i.session.startDate desc ")
    List<Session> getSessionByCustomer(@RequestParam Customer customer);

    Inscription getInscriptionById(Long id);

}
