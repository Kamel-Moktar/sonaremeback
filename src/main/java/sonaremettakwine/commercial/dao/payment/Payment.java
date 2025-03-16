package sonaremettakwine.commercial.dao.payment;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.customer.Customer;


import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Date date;
    String reference;
    Double amount;
    @ManyToOne
    Customer customer;


}
