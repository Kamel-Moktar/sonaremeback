package sonaremettakwine.commercial.dao.shippingslip;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.invoice.Invoice;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class ShippingSlip {
    @Id
    Long id;
    Long number;
    Date date;
    Date accuse;
    @OneToMany
    List<Invoice> invoices;
}
