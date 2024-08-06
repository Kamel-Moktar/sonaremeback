package sonaremettakwine.commercial.dao.inscription;

import com.fasterxml.jackson.databind.DatabindException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.session.Session;
import sonaremettakwine.commercial.dao.stagiaire.Stagiaire;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inscription {
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    Stagiaire stagiaire;
    @ManyToOne
    Session session;

    String inscriptionReference;
    Date arriveDate;
    Date exclusionDate;
    String exclusionReference;

}
