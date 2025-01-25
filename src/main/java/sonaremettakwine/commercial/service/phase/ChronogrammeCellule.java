package sonaremettakwine.commercial.service.phase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.phase.TypePhase;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChronogrammeCellule{
    TypePhase typePhase;
    Date date;
}
