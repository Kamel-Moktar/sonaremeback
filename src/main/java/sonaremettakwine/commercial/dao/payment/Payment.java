package sonaremettakwine.commercial.dao.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    Long id;
    Long number;
    Date date;
    String reference;
    Double amount;


}
