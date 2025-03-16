package sonaremettakwine.commercial.dao.realisationdispositif;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.action.Action;
import sonaremettakwine.commercial.dao.module.Module;
import sonaremettakwine.commercial.dao.phase.Phase;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RealisationDispositif {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    Module module;
    @ManyToOne
    Phase phase;
    Long durationHour;
}
