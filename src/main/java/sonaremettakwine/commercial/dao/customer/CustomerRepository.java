package sonaremettakwine.commercial.dao.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {


@Query("select c from Customer c order by c.id DESC " ) //trier les enregistrement
  List<Customer>  getAllSortByID();
@Query("Select c from Customer c " +
        " where upper(c.name) like '%'|| upper(:name) ||'%'" +
        " and upper(c.shortName) like '%'|| upper(:shortName) ||'%' order by c.id DESC")
    List<Customer> getCustomersByName(@RequestParam String name,@RequestParam String shortName);
}



