package sonaremettakwine.commercial.dao.formationdispositif;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sonaremettakwine.commercial.dao.action.Action;

import java.util.List;

@RepositoryRestResource
public interface FormationDispositifRepository extends JpaRepository<FormationDispositif,Long> {

   List< FormationDispositif> getAllByActionOrderByModuleName(Action action);
}
