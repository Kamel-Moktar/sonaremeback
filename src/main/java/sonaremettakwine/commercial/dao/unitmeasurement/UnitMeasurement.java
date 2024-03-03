package sonaremettakwine.commercial.dao.unitmeasurement;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitMeasurement {
    @Id
    Long Id;
    String name;
}
