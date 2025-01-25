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
            "  where   upper(s.familyName||' '||s.firstName) like '%'||upper(:fl)||'%' " +
            " and upper(s.firstName||' '||s.familyName) like '%'||upper(:fn)||'%' " +
            " and upper(s.customer.shortName) like '%'||upper(:cr)||'%' " +
            " order by s.familyName ")
    List<Stagiaire> getParamSortByName(

            @RequestParam String fl,
            @RequestParam String fn,
            @RequestParam String cr
    );
}
