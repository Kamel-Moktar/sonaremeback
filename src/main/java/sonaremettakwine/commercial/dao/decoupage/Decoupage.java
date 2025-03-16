package sonaremettakwine.commercial.dao.decoupage;

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
public class Decoupage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String communeName;
    String dairaName;
    String wilayaCode;
    String wilayaName;
}
