package sonaremettakwine.commercial.service.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.session.Session;
import sonaremettakwine.commercial.dao.session.SessionRepository;

import java.util.List;

@Service
@Transactional
public class SessionService {

    @Autowired
    SessionRepository sessionRepository;//

    public List<Session> getAll(){

        return sessionRepository.getAllSortByID();

    }

    public Session getSessionById(Long id){
        return sessionRepository.getReferenceById(id);
    }



    public Session add(Session session){
        return sessionRepository.save(session);
    }

    public void delete(Session session){ sessionRepository.delete(session);  }

    public Session update(Session session){

        Session session1=getSessionById(session.getId());
        session1.setName(session.getName());
        session1.setStartDate(session.getStartDate());
        session1.setEndDate(session.getEndDate());
        session1.setAction(session.getAction());
        session1.setNbrStagPlanned(session.getNbrStagPlanned());
        return session1;
    }

    public List<Session> getAllByNameByThemeByStartDate(String name, String theme, String date) {
        return sessionRepository.getAllByNameByThemeByStartDate(name,theme,date);
    }
}

