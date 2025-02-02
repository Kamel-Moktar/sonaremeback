package sonaremettakwine.commercial.service.phase;


import org.hibernate.type.descriptor.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.phase.*;
import sonaremettakwine.commercial.dao.session.Session;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class PhaseService {

    @Autowired
    PhaseRepository phaseRepository;//

    @Autowired
    TypePhaseRepository typePhaseRepository;

    public List<Phase> getAll() {

        return phaseRepository.getAllSortByID();

    }


    public List<Phase> getAllBySession(Session session) {

        return phaseRepository.getAllBySessionSortByStartDate(session);

    }

    public Phase getPhaseById(Long id) {
        return phaseRepository.getReferenceById(id);
    }


    public Phase add(Phase phase) {
        return phaseRepository.save(phase);
    }

    public void delete(Phase phase) {
        phaseRepository.delete(phase);
    }

    public Phase update(Phase phase) {

        Phase phase1 = getPhaseById(phase.getId());
        phase1.setName(phase.getName());
        phase1.setStartDate(phase.getStartDate());
        phase1.setEndDate(phase.getEndDate());
        phase1.setSession(phase.getSession());
        phase1.setLieuPhase(phase.getLieuPhase());
        phase1.setTypePhase(phase.getTypePhase());
        phase1.setDuration(phase.getDuration());

        return phase1;
    }

    public Phase setIsBilled(Long id,boolean isBilled ) {
        Phase phase1 = getPhaseById(id);
        phase1.setBilled(isBilled);
        return phase1;
    }

    public Phase phasePropose(Session session) {
        List<Phase> phases = phaseRepository.getAllBySessionSortByStartDate(session);
        Phase phase = new Phase();

        if (phases.isEmpty()) {
            phase.setName("FT 1");
            phase.setStartDate(session.getStartDate());
            phase.setTypePhase(typePhaseRepository.findByType("FT"));
            phase.setLieuPhase(LieuPhase.A_L_ECOLE);
        } else {
            Phase ph = phases.get(phases.size() - 1);
            phase.setName("FT");

            GregorianCalendar c = new GregorianCalendar();
            c.setTime(ph.getEndDate());
            c.add(GregorianCalendar.DAY_OF_MONTH, 2);
            phase.setStartDate(c.getTime());
            phase.setTypePhase(typePhaseRepository.findByType("FT"));
            phase.setLieuPhase(LieuPhase.A_L_ECOLE);
        }

        phase.setEndDate(session.getEndDate());


        return phase;
    }

    public List<TypePhase> getTypePhaseValues() {
        return typePhaseRepository.findAll();
    }

    public LieuPhase[] getLieuPhaseValues() {
        return LieuPhase.values();
    }


    public Chronogramme getChronogramme(Date d, Date f) {
        List<Phase> phases = phaseRepository.getPhaseForChronogramme(d, f);

        Session session = new Session();
        Chronogramme chronogramme = new Chronogramme();

        if (!phases.isEmpty()) {
            session = phases.get(0).getSession();
            ChronogrammeRow chronogrammeRow = new ChronogrammeRow();
            chronogrammeRow.setSession(session);

            for (Phase ph : phases) {
                if (!ph.getSession().equals(session)) {
                    chronogramme.getChronogrammeRows().add(chronogrammeRow);
                    session = ph.getSession();
                    chronogrammeRow = new ChronogrammeRow();
                    chronogrammeRow.setSession(session);
                }
                Date begin=d.compareTo(ph.getStartDate())>=0?d:ph.getStartDate();

                 while(begin.compareTo(ph.getEndDate())<=0 && begin.compareTo(f)<=0){
                     ChronogrammeCellule chronogrammeCellule=new ChronogrammeCellule(ph.getTypePhase(),begin);
                     chronogrammeRow.getCellules().add(chronogrammeCellule);
                     begin=new Date(begin.getTime()+ 24 * 60 * 60 * 1000);
                 }
            }
            chronogramme.getChronogrammeRows().add(chronogrammeRow);

        }
        return chronogramme;
    }


    public List<Phase> getAllBySessionForBilling(Session session) {
        return phaseRepository.getAllPhaseForBilling(session);
    }
}
