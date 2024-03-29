package sonaremettakwine.commercial.dao.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    Long Id;
    String name;
    String shortName;
    String RC;
    String IF;
    String NS;
    String NArticle;

}
