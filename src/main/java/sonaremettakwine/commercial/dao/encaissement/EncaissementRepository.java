package sonaremettakwine.commercial.dao.encaissement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;
import sonaremettakwine.commercial.dao.payment.Payment;

import java.util.List;


@RepositoryRestResource
public interface EncaissementRepository extends JpaRepository<Encaissement,Long> {

    @Query("select e from Encaissement  e where e.payment= :payment order by e.invoice.date")
    List<Encaissement> getEncaissementByPayment(@RequestParam Payment payment);
}
