package sonaremettakwine.commercial.dao.invoicedetail;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.benifit.Benefit;
import sonaremettakwine.commercial.dao.booking.Booking;
import sonaremettakwine.commercial.dao.inscription.Inscription;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.phase.Phase;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    Inscription inscription;
    @ManyToOne
    Benefit benefit;

    @ManyToOne
    Invoice invoice;

    @ManyToOne
    Phase phase;

    @ManyToOne
    Booking booking;


    Double qte;
    Double price;
    String obs;

}
