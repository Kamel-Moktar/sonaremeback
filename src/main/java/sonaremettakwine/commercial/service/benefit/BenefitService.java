package sonaremettakwine.commercial.service.benefit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.benifit.Benefit;
import sonaremettakwine.commercial.dao.benifit.BenefitRepository;


import java.util.List;

@Service
@Transactional
public class BenefitService {
    @Autowired
    BenefitRepository benefitRepository;//

    public List<Benefit> getAll(){ return benefitRepository.getAllSortByID();    }

    public Benefit getBenefitById(Long id){
        return benefitRepository.getReferenceById(id);
    }


    public Benefit add(Benefit benefit){
        return benefitRepository.save(benefit);
    }

    public void delete(Benefit benefit){ benefitRepository.delete(benefit);  }

    public Benefit update(Benefit benefit){

//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@"+benefit);

        Benefit benefit1=getBenefitById(benefit.getId());

        benefit1.setDesignation(benefit.getDesignation());
        benefit1.setDescription(benefit.getDescription());
        benefit1.setPrice(benefit.getPrice());
        benefit1.setSakina(benefit.getSakina());
        benefit1.setUnitMeasurement(benefit.getUnitMeasurement());


        return benefit1;
    }

}
