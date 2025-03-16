package sonaremettakwine.commercial.dao.action;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
@RepositoryRestResource
public interface  ActionRepository extends JpaRepository<Action ,Long> {

    @Query("select a from Action a order by a.Id DESC " ) //trier les enregistrement
    List<Action> getAllSortByID();

    @Query("select a from Action a " +
            " where upper(a.name) like '%'|| upper(:name)||'%' " +
            " and upper(a.domaine.name) like '%'|| upper(:domaineName)||'%'order by a.name" ) //trier les enregistrement
    List<Action> getAllSortByName(@RequestParam String name,@RequestParam String domaineName);

    Action getActionById(Long id);

}
