package sonaremettakwine.commercial.dao.phase;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.action.Action;
import sonaremettakwine.commercial.dao.session.Session;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phase {
    @Id @GeneratedValue
    Long id;

    String name;
    String startDate;
    String endDate;
    String type;
    TypePhase typePhase;
    LieuPhase lieuPhase;
    @ManyToOne
    Session session;
}



enum TypePhase{
    FT,
    FMT,
    COUPURE,
    RETOUR_UNITE
}

enum LieuPhase {
    SUR_SITE,
    A_L_ECOLE
}

//enum ModPhase{
//    PRESENTIELE,
//    VISIO,
//    E_LEARNING
//}
