package sonaremettakwine.commercial.dao.phase;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.action.Action;
import sonaremettakwine.commercial.dao.session.Session;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phase {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;
    Date startDate;
    Date endDate;
    String type;
    double duration;
    @ManyToOne
    TypePhase typePhase;
    LieuPhase lieuPhase;
    @ManyToOne
    Session session;
    boolean isBilled=false;


}


//enum ModPhase{
//    PRESENTIELE,
//    VISIO,
//    E_LEARNING
//}
