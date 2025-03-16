package sonaremettakwine.commercial.dao.offre;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import sonaremettakwine.commercial.dao.benifit.Benefit;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.proforma.Proforma;
import sonaremettakwine.commercial.dao.unit.Unit;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    @NonNull
    Proforma proforma;

    @ManyToOne
    @NonNull
    Benefit benefit;
    @NonNull
    Double number = 1D;
    @ManyToOne

    Unit unit;

    @NonNull
    Double quantity;
    @NonNull
    Double price;
    String observation;
}
