package sonaremettakwine.commercial.dao.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.domaine.Domaine;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {

    @Id @GeneratedValue
    Long id ;
    String name;
    String objectif;
    double durationHour;
    @ManyToOne
    Domaine domaine;

}
