package sonaremettakwine.commercial.dao.encaissement;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.payment.Payment;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Encaissement {
    @Id
    Long id;
    @ManyToOne
    Invoice invoice;
    @ManyToOne
    Payment payment;
    Double amount;
}
