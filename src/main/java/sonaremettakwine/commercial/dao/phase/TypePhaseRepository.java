package sonaremettakwine.commercial.dao.phase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TypePhaseRepository extends JpaRepository<TypePhase, Long> {

    TypePhase findByType(String type);
}
