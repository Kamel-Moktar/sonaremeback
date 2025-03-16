package sonaremettakwine.commercial.dao.phase;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class   TypePhase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String type;
    String label;
}



//        FT,
//        FMT,
//        COUPURE,
//        RETOUR_UNITE
