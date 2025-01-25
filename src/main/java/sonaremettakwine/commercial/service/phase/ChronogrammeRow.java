package sonaremettakwine.commercial.service.phase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import sonaremettakwine.commercial.dao.session.Session;


import java.util.LinkedList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChronogrammeRow {
    Session session;
   List<ChronogrammeCellule> cellules=new LinkedList<ChronogrammeCellule>();

}




