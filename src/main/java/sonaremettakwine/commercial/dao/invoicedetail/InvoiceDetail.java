package sonaremettakwine.commercial.dao.invoicedetail;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.benifit.Benefit;
import sonaremettakwine.commercial.dao.inscription.Inscription;
import sonaremettakwine.commercial.dao.invoice.Invoice;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetail {
    @Id
    Long id;

    @ManyToOne
    Inscription inscription;
    @ManyToOne
    Benefit benefit;

    @ManyToOne
    Invoice invoice;

    Double qte;
    Double price;
    String obs;

}
