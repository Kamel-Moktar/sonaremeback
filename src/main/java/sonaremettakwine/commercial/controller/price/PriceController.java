package sonaremettakwine.commercial.controller.price;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sonaremettakwine.commercial.dao.Price.Price;
import sonaremettakwine.commercial.dao.action.Action;
import sonaremettakwine.commercial.dao.benifit.Benefit;
import sonaremettakwine.commercial.dao.hotel.Hotel;
import sonaremettakwine.commercial.service.price.PriceService;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    PriceService priceService;


    @GetMapping("/")
    public List<Price> getAll() {
        return priceService.getAll();
    }

    @GetMapping("/param/{p}")
    public List<Price> getAllParam(@PathVariable String p) {
        return priceService.getAllParam(p);
    }



    @GetMapping("/{id}")
    public Price getPriceById(@PathVariable Long id) {
        return priceService.getPriceById(id);
    }


    @PostMapping("/")
    public Price add(@RequestBody Param param) {
        Price price1=new Price();
        List<Action> actions=param.getActions();
        List<Hotel> hotels=param.getHotels();

        if(hotels!=null){
            for(Hotel h:hotels) {
                price1 = new Price();
                price1.setBenefit(param.getBenefit());
                price1.setHotel(h);
                price1.setCout(param.getCout());
                price1.setPrice(param.getPrice());
                price1.setDate(param.getDate());;
                priceService.add(price1);
            }

        }
        if(actions!=null){
            for(Action  a:actions) {
                price1 = new Price();
                price1.setBenefit(param.getBenefit());
                price1.setAction(a);
                price1.setCout(param.getCout());
                price1.setPrice(param.getPrice());
                price1.setDate(param.getDate());
                priceService.add(price1);
            }
        }
        return price1;
    }


    @DeleteMapping("/{id}")
    public Price delete(@PathVariable Long id) {
        Price price=getPriceById(id);
        priceService.delete(price);
        return price;
    }

    @PutMapping("/")
    public Price update(@RequestBody Price price) {
        return priceService.update(price);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Param {
    List<Action> actions=new LinkedList<Action>();;
    List<Hotel> hotels=new LinkedList<Hotel>();
    Benefit benefit;
    Double cout;
    Double price;
    Date date;
}

