package sonaremettakwine.commercial.dao.benifit;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.unitmeasurement.UnitMeasurement;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Benefit {
    @Id
    Long Id;
    String designation;
    String description;
    String price;
    @ManyToOne
    UnitMeasurement unitMeasurement;

}
