package sonaremettakwine.commercial.dao.module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.domaine.Domaine;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id ;
    String name;
    String objectif;
    double durationHour;
    @ManyToOne
    Domaine domaine;

}
