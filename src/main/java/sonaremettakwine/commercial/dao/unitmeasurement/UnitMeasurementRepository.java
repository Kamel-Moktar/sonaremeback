package sonaremettakwine.commercial.dao.unitmeasurement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;
import sonaremettakwine.commercial.dao.customer.Customer;

import java.util.List;

@RepositoryRestResource
public interface UnitMeasurementRepository extends JpaRepository <UnitMeasurement,Long>{

    @Query("select c from UnitMeasurement c " +
            " where c.name like  %:name% " +
            "order by c.Id DESC " ) //trier les enregistrement
    List<UnitMeasurement> getAllSortByID(@RequestParam String name);


}
