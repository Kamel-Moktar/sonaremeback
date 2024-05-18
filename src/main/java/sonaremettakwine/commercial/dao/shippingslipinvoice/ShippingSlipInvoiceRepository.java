package sonaremettakwine.commercial.dao.shippingslipinvoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import sonaremettakwine.commercial.dao.shippingslip.ShippingSlip;

import java.util.List;

public interface ShippingSlipInvoiceRepository extends JpaRepository<ShippingSlipInvoice,Long> {
    @Query("select s from ShippingSlipInvoice  s where s.shippingSlip= :shippingSlip")
    List<ShippingSlipInvoice> getShippingSlipInvoiceByShippingSlip(@RequestParam ShippingSlip shippingSlip);
}
