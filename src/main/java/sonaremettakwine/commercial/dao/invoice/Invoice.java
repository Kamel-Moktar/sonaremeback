package sonaremettakwine.commercial.dao.invoice;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.NonNull;
import sonaremettakwine.commercial.dao.customer.Customer;

import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;//system JPA

    Long number;
    @NonNull
    Date date;
    String devise = "DZD";
    Double tva=0.09D;

    Double amountExcludingTax = 0d;//ht
    Double amountTax = 0d;  //tva
    Double amountIncludingTax = 0d;//ttc
    Double remains=0d;

    Double holdBackRat = 0D;  //retnue degaranté

    String reference;//contra convention bon de commande .....
    String object; //motif de facture une action de formation domiciliationn ....
    @ManyToOne
    @NonNull
    Customer customer;


}
