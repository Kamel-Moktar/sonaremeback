package sonaremettakwine.commercial.dao.shippingslip;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.customer.Customer;
import sonaremettakwine.commercial.dao.invoice.Invoice;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingSlip {
    @Id
    @GeneratedValue
    Long id;
    Long number;
    Date date;
    Date accuse;
    @ManyToOne
    Customer customer;

}
