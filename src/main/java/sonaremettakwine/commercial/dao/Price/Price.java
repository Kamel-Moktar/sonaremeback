package sonaremettakwine.commercial.dao.Price;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.action.Action;
import sonaremettakwine.commercial.dao.benifit.Benefit;
import sonaremettakwine.commercial.dao.hotel.Hotel;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    Action action;
    @ManyToOne
    Hotel hotel;
    @ManyToOne
    Benefit benefit;

    Double cout;
    Double price;

    Date date;

}
