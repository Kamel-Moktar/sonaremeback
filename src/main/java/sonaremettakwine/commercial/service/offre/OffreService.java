package sonaremettakwine.commercial.service.offre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.offre.Offre;
import sonaremettakwine.commercial.dao.offre.OffreRepository;
import sonaremettakwine.commercial.dao.proforma.Proforma ;

import sonaremettakwine.commercial.service.proforma.ProformaService;

import java.util.List;
@Service
@Transactional
public class OffreService {
    @Autowired
    OffreRepository offreRepository;
    @Autowired
    ProformaService proformaService;


    public List<Offre> getOffreByProforma (Proforma  proforma) {
        return offreRepository.getOffreByProforma (proforma);
    }

    public Offre add(Offre offre) {
        Proforma proforma = proformaService.getProformaById(offre.getProforma().getId());
        Offre offre1=offreRepository.save(offre);
        culeTotals(proforma);
        return offre1;
    }

    public void delete(Offre offre) {
        Proforma proforma = proformaService.getProformaById(offre.getProforma().getId());
        offreRepository.delete(offre);
        culeTotals(proforma);


    }

    public Offre getOffreById(Long id) {
        return offreRepository.getReferenceById(id);
    }

    public Offre update(Offre newOffre) {
        Offre offre = getOffreById(newOffre.getId());
        Proforma proforma = proformaService.getProformaById(offre.getProforma().getId());

        offre.setBenefit(newOffre.getBenefit());
        offre.setNumber(newOffre.getNumber());
        offre.setQuantity(newOffre.getQuantity());
        offre.setPrice(newOffre.getPrice());
        culeTotals(proforma);
        return offre;
    }


    public  void culeTotals(Proforma proforma) {

        List<Offre> offres = offreRepository.getOffreByProforma(proforma);
        double ht = offres.stream().mapToDouble(e -> e.getPrice() *e.getNumber()* e.getQuantity()).sum();
        proforma.setAmountExcludingTax(ht);
        proforma.setAmountTax(ht * proforma.getTva());
        proforma.setAmountIncludingTax(ht * (proforma.getTva() + 1));
        proforma.setRemains(ht * (proforma.getTva() + 1));
    }

}

