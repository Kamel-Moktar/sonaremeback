package sonaremettakwine.commercial.dao.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {


@Query("select c from Customer c order by c.id DESC " ) //trier les enregistrement
  List<Customer>  getAllSortByID();

}
