package sonaremettakwine.commercial.dao.benifit;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.unitmeasurement.UnitMeasurement;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Benefit {
    @Id @GeneratedValue(strategy =GenerationType.AUTO)
    Long Id;
    String designation;
    String description;
    double price;

    @ManyToOne (fetch = FetchType.EAGER)
    UnitMeasurement unitMeasurement;

}
