package sonaremettakwine.commercial.dao.unit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

@RepositoryRestResource
public interface UnitRepository extends JpaRepository<Unit,String> {
    @Query("select p from Unit p order by p.name " )
    List<Unit> getAllSortByName();
}

