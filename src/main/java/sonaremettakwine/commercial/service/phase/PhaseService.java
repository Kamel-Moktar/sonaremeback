package sonaremettakwine.commercial.service.phase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.phase.Phase;
import sonaremettakwine.commercial.dao.phase.PhaseRepository;
import sonaremettakwine.commercial.dao.session.Session;


import java.util.List;
@Service
@Transactional
public class PhaseService {

    @Autowired
    PhaseRepository phaseRepository;//

    public List<Phase> getAll(){

        return phaseRepository.getAllSortByID();

    }



    public List<Phase> getAllBySession(Session session){

        return phaseRepository.getAllBySessionSortByStartDate(session);

    }
    public Phase getPhaseById(Long id){
        return phaseRepository.getReferenceById(id);
    }



    public Phase add(Phase phase){
        return phaseRepository.save(phase);
    }

    public void delete(Phase phase){ phaseRepository.delete(phase);  }

    public Phase update(Phase phase){

        Phase phase1=getPhaseById(phase.getId());
        phase1.setName(phase.getName());
        phase1.setStartDate(phase.getStartDate());
        phase1.setEndDate(phase.getEndDate());
        phase1.setSession(phase.getSession());
        phase1.setLieuPhase(phase.getLieuPhase());
        phase1.setTypePhase(phase.getTypePhase());


        return phase1;
    }
}
