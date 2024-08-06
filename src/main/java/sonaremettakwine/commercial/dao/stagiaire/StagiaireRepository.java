package sonaremettakwine.commercial.dao.stagiaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource
public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {

    @Query("select s from Stagiaire s " +
            " order by s.familyName ")
    List<Stagiaire> getAllSortByName();

    @Query("select s from Stagiaire s " +
            "  where  format(s.birthDay ,'dd/mm/yyyy') like '%'||:bd||'%' " +
            " and upper(s.familyName) like '%'||upper(:fl)||'%' " +
            " and upper(s.firstName) like '%'||upper(:fn)||'%' " +
            " and upper(s.customer.shortName) like '%'||upper(:cr)||'%' " +
            " order by s.familyName ")
    List<Stagiaire> getParamSortByName(
            @RequestParam String bd,
            @RequestParam String fl,
            @RequestParam String fn,
            @RequestParam String cr
    );
}
