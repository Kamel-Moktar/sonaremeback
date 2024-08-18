package sonaremettakwine.commercial.dao.booking;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;
import sonaremettakwine.commercial.dao.hotel.Hotel;
import sonaremettakwine.commercial.dao.inscription.Inscription;
import sonaremettakwine.commercial.dao.stagiaire.Stagiaire;

import java.util.Date;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    Inscription inscription;
    @ManyToOne
    Hotel hotel;

    Date arriveDate;
    Date leavingDate;

    RoomType roomType;






}
