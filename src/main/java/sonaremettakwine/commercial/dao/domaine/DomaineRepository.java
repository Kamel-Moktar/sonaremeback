package sonaremettakwine.commercial.dao.domaine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

@RepositoryRestResource
public interface DomaineRepository extends JpaRepository<Domaine,Long> {
    @Query("select d from Domaine d order by d.id DESC ") //trier les enregistrement
    List<Domaine> getAllSortByID();
}
