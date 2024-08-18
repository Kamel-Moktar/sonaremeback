package sonaremettakwine.commercial.controller.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sonaremettakwine.commercial.dao.booking.Booking;
import sonaremettakwine.commercial.dao.booking.RoomType;
import sonaremettakwine.commercial.dao.inscription.Inscription;
import sonaremettakwine.commercial.dao.session.Session;
import sonaremettakwine.commercial.service.booking.BookingService;
import sonaremettakwine.commercial.service.inscription.InscriptionService;
import sonaremettakwine.commercial.service.session.SessionService;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;
    @Autowired
    InscriptionService inscriptionService;
   @Autowired
    SessionService sessionService;

    @GetMapping("/all")
    public List<Booking> getAll() {
        return bookingService.getAll();
    }

    @GetMapping("/roomtype")
    public RoomType[] getRoomType() {
        return RoomType.values();
    }

    @GetMapping("/allbystagiaire/{inscriptionId}")
    public List<Booking> getAllByInscription(@PathVariable  Long inscriptionId) {
        Inscription inscription=inscriptionService.getInscriptionById(inscriptionId);
        return bookingService.getBookingByInscription(inscription);
    }


    @GetMapping("/favoritebooking/{sessionId}")
    public List<Booking> getFavoriteBooking(@PathVariable  Long sessionId) {
        Session session=sessionService.getSessionById(sessionId);
        return bookingService.favoriteBooking(session);
    }


    @GetMapping("bysession/{sessionId}")
    public List<Booking> getAllBySession(@PathVariable  Long sessionId) {
        Session session=sessionService.getSessionById(sessionId);
        return bookingService.getBookingBySession(session);
    }

    @GetMapping("/byid/{id}")
    public Booking getById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping("/add")
    public Booking add(@RequestBody Booking booking) {
        return bookingService.add(booking);
    }

    @PostMapping("/delete")
    public Booking delete(@RequestBody Booking booking) {
        bookingService.delete(booking);
        return booking;
    }

    @PostMapping("/update")
    public Booking update(@RequestBody Booking booking) {
        return bookingService.update(booking);
    }
}
