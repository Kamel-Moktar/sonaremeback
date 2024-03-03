package sonaremettakwine.commercial.dao.encaissement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EncaissementRepository extends JpaRepository<Encaissement,Long> {
}
