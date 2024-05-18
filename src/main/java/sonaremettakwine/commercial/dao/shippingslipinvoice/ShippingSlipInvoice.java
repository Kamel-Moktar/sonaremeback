package sonaremettakwine.commercial.dao.shippingslipinvoice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.shippingslip.ShippingSlip;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingSlipInvoice {
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    ShippingSlip shippingSlip;
    @ManyToOne
    Invoice invoice;
    String nbrPage;
    String obs;
}
