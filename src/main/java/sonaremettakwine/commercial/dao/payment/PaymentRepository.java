package sonaremettakwine.commercial.dao.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;


@RepositoryRestResource
public interface PaymentRepository extends JpaRepository<Payment,Long> {

    @Query("select p from Payment p order by p.id DESC " )
    List<Payment> getAllSortByID();

    Payment getPaymentById(Long id);
}
