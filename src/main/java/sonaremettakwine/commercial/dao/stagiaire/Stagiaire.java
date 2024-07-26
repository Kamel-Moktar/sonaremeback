package sonaremettakwine.commercial.dao.stagiaire;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    String adresses;
    String phoneNumber;
    String eMail;






}
