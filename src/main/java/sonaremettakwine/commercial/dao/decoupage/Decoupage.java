package sonaremettakwine.commercial.dao.decoupage;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Decoupage {
    @Id
    Long id;
    String communeName;
    String dairaName;
    String wilayaCode;
    String wilayaName;
}
