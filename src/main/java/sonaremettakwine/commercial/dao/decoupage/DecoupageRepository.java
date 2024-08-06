package sonaremettakwine.commercial.dao.decoupage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource
public interface DecoupageRepository extends JpaRepository<Decoupage, Long> {

    @Query("select distinct new sonaremettakwine.commercial.dao.decoupage.Wilaya(c.wilayaCode,c.wilayaName)" +
            "  from Decoupage c    " +
            "  order by c.wilayaCode")
    List<Wilaya> getAllWilaya();

    @Query("select w from Decoupage w  " +
            " where w.wilayaName= :wilayaName" +
            " order by w.communeName")
    List<Decoupage> getCommuneByWilaya(@RequestParam String wilayaName);
}
