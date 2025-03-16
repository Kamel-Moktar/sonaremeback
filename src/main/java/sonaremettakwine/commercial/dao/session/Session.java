package sonaremettakwine.commercial.dao.session;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.action.Action;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long   id;
    String name;
    Date startDate;
    Date endDate;
    Short  nbrStagPlanned;
    @ManyToOne
    Action action;
}
