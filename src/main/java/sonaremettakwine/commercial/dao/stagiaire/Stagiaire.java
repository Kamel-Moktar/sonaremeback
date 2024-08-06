package sonaremettakwine.commercial.dao.stagiaire;

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
public class Stagiaire {
    @Id
    @GeneratedValue
    Long id;
    String firstName;
    String familyName;
    Date birthDay;
    String birthPlace;
    String adresse;
    String phoneNumber;
    String mailAdresse;
    @ManyToOne
    Customer customer;

}
