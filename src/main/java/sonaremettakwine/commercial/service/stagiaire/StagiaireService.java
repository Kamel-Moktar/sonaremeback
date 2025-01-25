package sonaremettakwine.commercial.service.stagiaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import sonaremettakwine.commercial.dao.stagiaire.Stagiaire;
import sonaremettakwine.commercial.dao.stagiaire.StagiaireRepository;

import java.util.List;

@Service
@Transactional
public class StagiaireService {


    @Autowired
    StagiaireRepository stagiaireRepository;//

    public List<Stagiaire> getAll() {

        return stagiaireRepository.getAllSortByName();

    }

    public Stagiaire getStagiaireById(Long id) {
        return stagiaireRepository.getReferenceById(id);
    }

    public List<Stagiaire> getAllParam(String familyName, String firstName, String birthDay, String customer) {
        return stagiaireRepository.getParamSortByName(

               familyName ,
                firstName,
                customer
        );
    }

    public Stagiaire add(Stagiaire stagiaire) {

        return stagiaireRepository.save(stagiaire);
    }

    public void delete(Stagiaire stagiaire) {
        stagiaireRepository.delete(stagiaire);
    }

    public Stagiaire update(Stagiaire stagiaire) {

        Stagiaire stagiaire1 = getStagiaireById(stagiaire.getId());
        stagiaire1.setFamilyName(stagiaire.getFamilyName());
        stagiaire1.setFirstName(stagiaire.getFirstName());
        stagiaire1.setBirthDay(stagiaire.getBirthDay());
        stagiaire1.setBirthPlace(stagiaire.getBirthPlace());
        stagiaire1.setAdresse(stagiaire.getAdresse());
        stagiaire1.setPhoneNumber(stagiaire.getPhoneNumber());
        stagiaire1.setMailAdresse(stagiaire.getMailAdresse());
        stagiaire1.setGsp(stagiaire.getGsp());
        stagiaire1.setSchoolLevel(stagiaire.getSchoolLevel());
        stagiaire1.setSexe(stagiaire.getSexe());


        return stagiaire1;
    }
}


