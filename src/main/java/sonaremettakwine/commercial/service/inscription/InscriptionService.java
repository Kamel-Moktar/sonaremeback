package sonaremettakwine.commercial.service.inscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.customer.Customer;
import sonaremettakwine.commercial.dao.inscription.Inscription;
import sonaremettakwine.commercial.dao.inscription.InscriptionRepository;
import sonaremettakwine.commercial.dao.session.Session;
import sonaremettakwine.commercial.dao.stagiaire.Stagiaire;
import sonaremettakwine.commercial.service.session.SessionService;
import sonaremettakwine.commercial.service.stagiaire.StagiaireService;

import java.util.List;
@Service
@Transactional
public class InscriptionService {
    @Autowired
    InscriptionRepository inscriptionRepository;//
    @Autowired
    SessionService sessionService;

    @Autowired
    StagiaireService stagiaireService;

    public List<Inscription> getAll(){
        return inscriptionRepository.findAll();
    }

    public Inscription getInscriptionById(Long id){
        return inscriptionRepository.getInscriptionById(id);
    }



    public Inscription add(Inscription inscription){
        return inscriptionRepository.save(inscription);
    }

    public void delete(Inscription inscription){ inscriptionRepository.delete(inscription);  }

    public Inscription update(Inscription inscription){
        Inscription inscription1=getInscriptionById(inscription.getId());
        inscription1.setStagiaire(inscription.getStagiaire());
        inscription1.setSession(inscription.getSession());
        inscription1.setArriveDate(inscription.getArriveDate());
        inscription1.setInscriptionReference(inscription.getInscriptionReference());
        inscription1.setExclusionDate(inscription.getExclusionDate());
        inscription1.setExclusionReference(inscription.getExclusionReference());
        return inscription1;
    }



    public List<Inscription> getAllBySession(Long sessionId) {

        Session session=sessionService.getSessionById(sessionId);
        return inscriptionRepository.getAllBySession(session);
    }

    public List<Inscription> getAllByStagiaire(Long stagiaireId) {
        Stagiaire stagiaire=stagiaireService.getStagiaireById(stagiaireId);
        return inscriptionRepository.getAllByStagiaire(stagiaire);
    }

    public List<Inscription> getByStagiaireCustomer(Customer customer,Session session){
        return inscriptionRepository.getBySessionAndStagiaireCustomerAndArriveDateNotNullOrderByStagiaireFirstName(session,customer);
    }

    public List<Session> getSessionByCustomer(Customer customer){
        return inscriptionRepository.getSessionByCustomer(customer);
    }
}

