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
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    Invoice invoice;

    @ManyToOne
    Benefit benefit;


    Double number=1D;
    @ManyToOne
    Unit unit;

    Double quantity;
    Double price;

    String observation;


}
