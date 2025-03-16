package sonaremettakwine.commercial.dao.action;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.domaine.Domaine;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String shortName;
    String objectif;
    String but;
    double duration;
    double durationHour;
    String type;
    @ManyToOne
    Domaine domaine;
}
