package sonaremettakwine.commercial.service.stagiaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.stagiaire.Stagiaire;
import sonaremettakwine.commercial.dao.stagiaire.StagiaireRepository;

import java.util.List;
@Service
@Transactional
public class StagiaireService {


    @Autowired
    StagiaireRepository stagiaireRepository;//

    public List<Stagiaire> getAll(){

        return stagiaireRepository.getAllSortByName();

    }

    public Stagiaire getStagiaireById(Long id){
        return stagiaireRepository.getReferenceById(id);
    }



    public Stagiaire add(Stagiaire stagiaire){
        return stagiaireRepository.save(stagiaire);
    }

    public void delete(Stagiaire stagiaire){ stagiaireRepository.delete(stagiaire);  }

    public Stagiaire update(Stagiaire stagiaire){

        Stagiaire stagiaire1=getStagiaireById(stagiaire.getId());
        stagiaire1.setFamilyName(stagiaire.getFamilyName());
        stagiaire1.setFirstName(stagiaire.getFirstName());
        stagiaire1.setBirthDay(stagiaire.getBirthDay());
        stagiaire1.setBirthPlace(stagiaire.getBirthPlace());
        stagiaire1.setAdresses(stagiaire.getAdresses());
        stagiaire1.setPhoneNumber(stagiaire.getPhoneNumber());
        stagiaire1.setEMail(stagiaire.getEMail());



        return stagiaire1;
    }
}


