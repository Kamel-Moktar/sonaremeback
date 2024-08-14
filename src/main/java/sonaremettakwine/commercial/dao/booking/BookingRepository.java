package sonaremettakwine.commercial.dao.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sonaremettakwine.commercial.dao.hotel.Hotel;
import sonaremettakwine.commercial.dao.inscription.Inscription;

import java.util.List;
@RepositoryRestResource
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> getBookingByInscription(Inscription inscription);

    List<Booking> getBookingByHotel(Hotel hotel);

    Booking getBookingById(Long id);




}
