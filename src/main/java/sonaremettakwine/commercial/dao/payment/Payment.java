package sonaremettakwine.commercial.dao.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
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
    @Id @GeneratedValue
    Long id;
    Date date;
    String reference;
    Double amount;
    @ManyToOne
    Customer customer;


}
