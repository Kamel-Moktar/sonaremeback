package sonaremettakwine.commercial.dao.encaissement;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.payment.Payment;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Encaissement {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    @NonNull
    Invoice invoice;
    @ManyToOne
    @NonNull
    Payment payment;
    @NonNull
    Double amount;
    String obs;
}
