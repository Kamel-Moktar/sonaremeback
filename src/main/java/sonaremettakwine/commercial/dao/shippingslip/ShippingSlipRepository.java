package sonaremettakwine.commercial.dao.shippingslip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShippingSlipRepository extends JpaRepository<ShippingSlip,Long> {
}
