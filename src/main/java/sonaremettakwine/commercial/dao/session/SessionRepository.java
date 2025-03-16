package sonaremettakwine.commercial.dao.session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
@RepositoryRestResource
public interface SessionRepository extends JpaRepository<Session,Long> {
    @Query("select s from Session s  order by s.id DESC" )
    List<Session> getAllSortByID();



    @Query("select s from Session  s " +
            " where format(s.startDate ,'dd/mm/yyyy') like '%'||:startDate||'%'" +
            " and upper(s.action.name) like '%'||upper(:theme)||'%'" +
            " and upper(s.name) like '%'||upper(:name)||'%'" +
            " order by s.startDate DESC")
    List<Session> getAllByNameByThemeByStartDate(@RequestParam String name,@RequestParam String theme, @RequestParam String startDate);

    Session getSessionById(Long id);
}
