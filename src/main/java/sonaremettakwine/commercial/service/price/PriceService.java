package sonaremettakwine.commercial.service.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.Price.Price;
import sonaremettakwine.commercial.dao.Price.PriceRepository;
import sonaremettakwine.commercial.dao.action.Action;
import sonaremettakwine.commercial.dao.benifit.Benefit;
import sonaremettakwine.commercial.dao.hotel.Hotel;

import java.util.List;

@Service
@Transactional
public class PriceService {


    @Autowired
    PriceRepository priceRepository;

    public List<Price> getAll() {
        return priceRepository.findAll();
    }


    public Price getPriceById(Long id) {
        return priceRepository.getPriceById(id);
    }


    public Price add(Price price) {
        return priceRepository.save(price);
    }

    public void delete(Price price) {
        priceRepository.delete(price);
    }

    public Price update(Price price) {
        Price price1 = getPriceById(price.getId());
        price1.setBenefit(price.getBenefit());
        price1.setHotel(price.getHotel());
        price1.setAction(price1.getAction());
        price1.setCout(price.getCout());
        price1.setPrice(price.getPrice());
        price1.setDate(price1.getDate());
        return price1;
    }

    public List<Price> getAllParam(String p) {
        return priceRepository.getAllParam(p);
    }

    public List<Price> getAllByBenifitByAction(Benefit benefit, Action action) {
        return priceRepository.getAllByBenefitAndActionOrderByDateAsc(benefit,action);
    }

    public List<Price> getAllByBenifitByHotel(Benefit benefit, Hotel hotel) {
        return priceRepository.getAllByBenefitAndHotelOrderByDateAsc(benefit,hotel);

    }
}



