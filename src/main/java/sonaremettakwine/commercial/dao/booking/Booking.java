package sonaremettakwine.commercial.dao.booking;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.hotel.Hotel;
import sonaremettakwine.commercial.dao.inscription.Inscription;
import sonaremettakwine.commercial.dao.stagiaire.Stagiaire;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    private Long id;
    @ManyToOne
    Inscription inscription;
    @ManyToOne
    Hotel hotel;

    Date arriveDate;
    Date leavingDate;

    RoomType roomType;






}
