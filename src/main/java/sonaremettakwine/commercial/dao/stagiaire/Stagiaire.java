package sonaremettakwine.commercial.dao.stagiaire;

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
public class Stagiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String firstName;
    String familyName;
    Date birthDay;
    String birthPlace;
    String adresse;
    String phoneNumber;
    String mailAdresse;
    Sexe sexe=Sexe.M;
    String schoolLevel;
    String gsp;
    @ManyToOne
    Customer customer;

}


