package sonaremettakwine.commercial.service.phase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.phase.Phase;


import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChronogrammeCellule{
    Phase Phase;
    Date date;
}
