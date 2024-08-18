package sonaremettakwine.commercial.service.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.booking.Booking;
import sonaremettakwine.commercial.dao.booking.BookingRepository;
import sonaremettakwine.commercial.dao.inscription.Inscription;
import sonaremettakwine.commercial.dao.session.Session;
import sonaremettakwine.commercial.dao.stagiaire.Stagiaire;
import sonaremettakwine.commercial.service.inscription.InscriptionService;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;//
    @Autowired
    InscriptionService inscriptionService;

    public List<Booking> getBookingByInscription(Inscription inscription) {
        return bookingRepository.getBookingByInscription(inscription);
    }

    public List<Booking> getBookingByStagiaire(Stagiaire stagiaire) {
        return bookingRepository.getBookingByStagiaire(stagiaire);
    }

    public List<Booking> getBookingBySession(Session session) {
        return bookingRepository.getBookingBySession(session);
    }

    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.getReferenceById(id);
    }


    public Booking add(Booking booking) {
        if (!alreadyReserved(booking))
            return bookingRepository.save(booking);

        return null;

    }

    public List<Booking> favoriteBooking(Session session) {
        List<Booking> bookings = new LinkedList<Booking>();
        List<Inscription> inscriptions = inscriptionService.getAllBySession(session.getId());

        for (Inscription i : inscriptions) {
            List<Booking> bookingsInscription = bookingRepository.getBookingByInscription(i);
            boolean isPast=true;
            for (Booking b : bookingsInscription) {
                Date d = new Date();
                if (d.compareTo(b.getArriveDate()) <= 0) {
                    bookings.add(b);
                    isPast=false;
                    break;
                }
                if (d.compareTo(b.getLeavingDate()) <= 0) {
                    bookings.add(b);
                    isPast=false;
                    break;
                }

            }
            if(isPast && !bookingsInscription.isEmpty()) {
                bookings.add(bookingsInscription.get(bookingsInscription.size()-1));
            }


        }


        return bookings;
    }


    public void delete(Booking booking) {
        bookingRepository.delete(booking);
    }

    public Booking update(Booking booking) {

        if (!alreadyReserved(booking)) {
            Booking booking1 = getBookingById(booking.getId());
            booking1.setHotel(booking.getHotel());
            booking1.setArriveDate(booking.getArriveDate());
            booking1.setLeavingDate(booking.getLeavingDate());
            booking1.setRoomType(booking.getRoomType());
            return booking1;
        }
        return null;
    }

    public boolean alreadyReserved(Booking booking) {
        boolean already = false;
        List<Booking> bookings = getBookingByStagiaire(booking.getInscription().getStagiaire());
        for (Booking b : bookings) {
            if (b.getArriveDate().compareTo(booking.getLeavingDate()) <= 0 && b.getLeavingDate().compareTo(booking.getArriveDate()) >= 0
                    && !b.getId().equals(booking.getId())) {
                already = true;
                break;
            }
        }

        return already;
    }



}
