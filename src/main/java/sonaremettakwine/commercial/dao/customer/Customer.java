package sonaremettakwine.commercial.dao.customer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.context.annotation.Lazy;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @NonNull
    String name;
    @NonNull
    String shortName;
    @NonNull
    String adresse;
    String phoneNumber;
    String fax;
    String numRc;
    String idFiscal;
    String idStatistic ;
    String numArticle;

}
