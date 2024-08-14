package sonaremettakwine.commercial.controller.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sonaremettakwine.commercial.dao.hotel.Hotel;
import sonaremettakwine.commercial.service.hotel.HotelService;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @GetMapping("/all")
    public List<Hotel> getAll(){
        return hotelService.getAll();
    }

    @GetMapping("/byid/{id}")
    public Hotel getById(@PathVariable Long id){
        return hotelService.getHotelById(id);
    }


    @PostMapping("/add")
    public Hotel add(@RequestBody Hotel hotel){

        return hotelService.add(hotel);

    }
    @PostMapping("/delete")
    public Hotel delete(@RequestBody  Hotel hotel){
        hotelService.delete(hotel);
        return hotel;
    }

    @PostMapping("/update")
    public Hotel update(@RequestBody  Hotel hotel){
        return  hotelService.update(hotel);

    }
}
