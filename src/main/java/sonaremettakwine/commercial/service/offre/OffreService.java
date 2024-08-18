package sonaremettakwine.commercial.service.offre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.benifit.Tva;
import sonaremettakwine.commercial.dao.offre.Offre;
import sonaremettakwine.commercial.dao.offre.OffreRepository;
import sonaremettakwine.commercial.dao.proforma.Proforma;
import sonaremettakwine.commercial.service.proforma.ProformaService;

import java.util.List;

@Service
@Transactional
public class OffreService {
    @Autowired
    OffreRepository offreRepository;
    @Autowired
    ProformaService proformaService;


    public List<Offre> getOffreByProforma(Proforma proforma) {
        return offreRepository.getOffreByProforma(proforma);
    }

    public List<Offre> getOffreByProformaByTva(Proforma proforma, double tva) {
        return offreRepository.getOffreByProformaByTva(proforma,tva);
    }
    public Offre add(Offre offre) {
        Proforma proforma = proformaService.getProformaById(offre.getProforma().getId());
        Offre offre1 = offreRepository.save(offre);
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


    public double getTotalTva(Proforma proforma, double taux) {
        List<Offre> offres = offreRepository.getOffreByProformaByTva(proforma,taux);
        return offres.stream().mapToDouble(
                e -> e.getPrice() * e.getNumber() * e.getQuantity()*e.getBenefit().getTva()).sum();
    }



    public void culeTotals(Proforma proforma) {

        List<Offre> offres = offreRepository.getOffreByProforma(proforma);
        double ht = offres.stream().mapToDouble(e -> e.getPrice() * e.getNumber() * e.getQuantity()).sum();
        double tvaNormal=getTotalTva(proforma,Tva.NORMAL.getTaux().doubleValue());
        double tvaReduite=getTotalTva(proforma,Tva.REDUITE.getTaux().doubleValue());
        double tva=tvaNormal+tvaReduite;
        double ttc=tva+ht;

        proforma.setAmountExcludingTax(ht);
        proforma.setAmountTax(tva);
        proforma.setAmountIncludingTax(ttc);
        //proforma.setRemains(ht * (proforma.get() + 1));
    }

}

