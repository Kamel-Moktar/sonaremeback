package sonaremettakwine.commercial.dao.phase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;
import sonaremettakwine.commercial.dao.session.Session;


import java.util.List;
@RepositoryRestResource
public interface PhaseRepository extends JpaRepository<Phase,Long> {
    @Query("select p from Phase p order by p.id DESC " )
    List<Phase> getAllSortByID();


    @Query("select p from Phase p " +
            " where p.session = :session " +
            " order by p.startDate DESC " )
    List<Phase> getAllBySessionSortByStartDate(@RequestParam Session session);

}
