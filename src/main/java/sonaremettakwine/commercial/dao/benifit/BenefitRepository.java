package sonaremettakwine.commercial.dao.benifit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface BenefitRepository extends JpaRepository<Benefit,Long> {

}
