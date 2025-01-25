package sonaremettakwine.commercial.dao.formationdispositif;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.action.Action;
import sonaremettakwine.commercial.dao.module.Module;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor
public class FormationDispositif {
    @Id @GeneratedValue
    Long id;
    @ManyToOne
    Module module;
    @ManyToOne
    Action action;
    Long durationHour;


}

