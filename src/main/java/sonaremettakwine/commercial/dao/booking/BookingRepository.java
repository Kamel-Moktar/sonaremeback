package sonaremettakwine.commercial.dao.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;
import sonaremettakwine.commercial.dao.hotel.Hotel;
import sonaremettakwine.commercial.dao.inscription.Inscription;
import sonaremettakwine.commercial.dao.session.Session;
import sonaremettakwine.commercial.dao.stagiaire.Stagiaire;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("select b from Booking b" +
            "  where b.inscription=:inscription " +
            "  order by b.arriveDate ")
    List<Booking> getBookingByInscription(@RequestParam Inscription inscription);

    @Query("select b from Booking b" +
            "  where b.inscription.stagiaire=:stagiaire ")
    List<Booking> getBookingByStagiaire(@RequestParam Stagiaire stagiaire);

    @Query("select b from Booking b" +
            "  where b.inscription.session=:session " +
            " order by b.inscription.id , b.arriveDate")
    List<Booking> getBookingBySession(@RequestParam Session session);

    @Query("select b from Booking b" +
            "  where b.hotel=:hotel ")
    List<Booking> getBookingByHotel(@RequestParam Hotel hotel);

    Booking getBookingById(Long id);

    @Query("select b from Booking  b " +
            " where b.leavingDate >= :d " +
            " and  b.arriveDate <= :f " +
            " and b.inscription= :inscription")
    List<Booking> getBookingsInPeriodeByInscription(@RequestParam  Inscription inscription,@RequestParam Date d,@RequestParam Date f);

}
