package sonaremettakwine.commercial.dao.realisationdispositif;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RealisationDispositifRepository extends JpaRepository <RealisationDispositif,Long>{
    RealisationDispositif getRealisationDispositifById(Long id);
}
