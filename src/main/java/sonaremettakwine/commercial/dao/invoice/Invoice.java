package sonaremettakwine.commercial.dao.invoice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import sonaremettakwine.commercial.dao.customer.Customer;

import java.util.Date;

@Entity
public class Invoice {
    @Id
    Long id;
    Long number;
    Date date;
    String devise;
    Double amountExcludingTax;
    Double amountTax;
    Double amountIncludingTax;
    Double holdBackRat;
    @ManyToOne
    Customer customer;



}
