package sonaremettakwine.commercial.dao.realisationdispositif;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    @GeneratedValue
    Long id;
    @ManyToOne
    Module module;
    @ManyToOne
    Phase phase;
    Long durationHour;
}
