package sonaremettakwine.commercial.dao.sale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonaremettakwine.commercial.dao.benifit.Benefit;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.session.Session;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vente {

    Invoice invoice;
    Benefit  benefit;
    Session session;
    Double price;
    Long number;
    Double quantity;



}
