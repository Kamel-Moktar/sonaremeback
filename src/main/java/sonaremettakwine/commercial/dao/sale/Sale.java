package sonaremettakwine.commercial.dao.sale;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import sonaremettakwine.commercial.dao.benifit.Benefit;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.unit.Unit;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id @GeneratedValue
    Long id;
    @ManyToOne
    @NonNull
    Invoice invoice;

    @ManyToOne
    @NonNull
    Benefit benefit;
    @NonNull
    Double number=1D;
    @ManyToOne
    @NonNull
    Unit unit;

    @NonNull
    Double quantity;
    @NonNull
    Double price;
    String observation;


}
