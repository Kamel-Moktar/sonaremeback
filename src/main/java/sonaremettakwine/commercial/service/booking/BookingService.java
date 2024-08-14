package sonaremettakwine.commercial.service.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.booking.Booking;
import sonaremettakwine.commercial.dao.booking.BookingRepository;
import sonaremettakwine.commercial.dao.inscription.Inscription;

import java.util.List;

@Service
@Transactional
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;//


    public List<Booking> getBookingByInscription(Inscription inscription ){
        return bookingRepository.getBookingByInscription(inscription);
    }

    public List<Booking> getAll(){ return bookingRepository.findAll();    }

    public Booking getBookingById(Long id){
        return bookingRepository.getReferenceById(id);
    }


    public Booking add(Booking booking){
        return bookingRepository.save(booking);
    }

    public void delete(Booking booking){ bookingRepository.delete(booking);  }

    public Booking update(Booking booking){
        Booking booking1=getBookingById(booking.getId());
        booking1.setHotel(booking.getHotel());
        booking1.setArriveDate(booking.getArriveDate());
        booking1.setLeavingDate(booking.getLeavingDate());
        booking1.setRoomType(booking.getRoomType());
        return booking1;
    }

}
