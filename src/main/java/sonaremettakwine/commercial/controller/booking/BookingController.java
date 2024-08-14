package sonaremettakwine.commercial.controller.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sonaremettakwine.commercial.dao.booking.Booking;
import sonaremettakwine.commercial.dao.booking.RoomType;
import sonaremettakwine.commercial.service.booking.BookingService;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;


    @GetMapping("/all")
    public List<Booking> getAll() {
        return bookingService.getAll();
    }

    @GetMapping("/roomtype")
    public RoomType[] getRoomType() {
        return RoomType.values();
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

    @PutMapping("/update")
    public Booking update(@RequestBody Booking booking) {
        return bookingService.update(booking);
    }
}
