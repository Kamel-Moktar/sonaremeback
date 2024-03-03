package sonaremettakwine.commercial.dao.sale;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.benifit.Benefit;
import sonaremettakwine.commercial.dao.invoice.Invoice;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id
    Long id;
    @ManyToOne
    Invoice invoice;

    @ManyToOne
    Benefit benefit;

    Double quantity;
    Double price;


}
