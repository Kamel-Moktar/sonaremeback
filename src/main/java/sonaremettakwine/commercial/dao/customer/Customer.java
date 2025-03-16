package sonaremettakwine.commercial.dao.customer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    String shortName;

    String adresse;
    String phoneNumber;
    String fax;
    String numRc;
    String idFiscal;
    String idStatistic;
    String numArticle;
    @Column(columnDefinition = ("boolean  default false"))
    boolean exemptFromTax;
    @Column(columnDefinition = ("boolean  default false"))
    boolean sameCompany;

}
