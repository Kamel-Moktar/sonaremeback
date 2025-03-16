package sonaremettakwine.commercial.dao.Price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;
import sonaremettakwine.commercial.dao.action.Action;
import sonaremettakwine.commercial.dao.benifit.Benefit;
import sonaremettakwine.commercial.dao.hotel.Hotel;

import java.util.List;

@RepositoryRestResource
public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query("select pr from Price pr " +
            " where " +
            " upper(pr.benefit.designation||pr.hotel.name) like '%'||upper(:p)||'%' " +
            "and pr.hotel is not null" +
            " union all " +
            "select pr from Price pr " +
            "where " +
            "upper(pr.benefit.designation||pr.action.name) like '%'||upper(:p)||'%' " +
            " and pr.action.name is not null")
    List<Price> getAllParam(@RequestParam String p);

    List<Price> getAllByBenefitAndActionOrderByDateAsc(Benefit benefit, Action action);

    List<Price> getAllByBenefitAndHotelOrderByDateAsc(Benefit benefit, Hotel hotel);

    Price getPriceById(Long id);
}
