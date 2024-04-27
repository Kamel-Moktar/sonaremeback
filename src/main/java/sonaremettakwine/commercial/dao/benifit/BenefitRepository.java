package sonaremettakwine.commercial.dao.benifit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource

public interface BenefitRepository extends JpaRepository<Benefit,Long> {
    @Query("select c from Benefit c order by c.Id DESC " ) //trier les enregistrement
    List<Benefit> getAllSortByID();

}
