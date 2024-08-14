package sonaremettakwine.commercial.dao.hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

@RepositoryRestResource
public interface HotelRepository extends JpaRepository<Hotel,Long> {
    @Query("select d from Hotel d order by d.id DESC ") //trier les enregistrement
    List<Hotel> getAllSortByID();
}
