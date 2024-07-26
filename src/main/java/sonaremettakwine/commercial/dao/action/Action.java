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
    Long Id;
    String name;
    String shortName;
    String Objectif;
    String but;
    double duration;
    double durationHour;
    @ManyToOne
    Domaine domaine;
}
