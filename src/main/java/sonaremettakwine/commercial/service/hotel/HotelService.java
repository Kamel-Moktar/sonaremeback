package sonaremettakwine.commercial.service.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sonaremettakwine.commercial.dao.hotel.Hotel;
import sonaremettakwine.commercial.dao.hotel.HotelRepository;


import java.util.List;

@Service
@Transactional
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public List<Hotel> getAll() {
        return hotelRepository.getAllSortByID();
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.getReferenceById(id);
    }


    public Hotel add(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void delete(Hotel hotel) {
        hotelRepository.delete(hotel);
    }

    public Hotel update(Hotel hotel) {
        Hotel hotel1 = getHotelById(hotel.getId());
        hotel1.setName(hotel.getName());
        return hotel1;
    }
}
