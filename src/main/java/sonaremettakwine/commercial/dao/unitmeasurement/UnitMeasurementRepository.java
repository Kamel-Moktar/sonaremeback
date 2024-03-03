package sonaremettakwine.commercial.dao.unitmeasurement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UnitMeasurementRepository extends JpaRepository <UnitMeasurement,Long>{
}
