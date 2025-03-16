package sonaremettakwine.commercial.service.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.action.Action;
import sonaremettakwine.commercial.dao.action.ActionRepository;

import java.util.List;

@Service
@Transactional
public class ActionService {
    @Autowired
    ActionRepository actionRepository;//

    public List<Action> getAll() {
        return actionRepository.getAllSortByID();
    }

    public List<Action> getAllOrderByName(String name, String domaineName) {
        return actionRepository.getAllSortByName(name, domaineName);
    }

    public Action getActionById(Long id) {
        return actionRepository.getActionById(id);
    }


    public Action add(Action action) {
        return actionRepository.save(action);
    }

    public void delete(Action action) {
        actionRepository.delete(action);
    }

    public Action update(Action action) {
        Action action1 = getActionById(action.getId());
        action1.setName(action.getName());
        action1.setBut(action.getBut());
        action1.setObjectif(action.getObjectif());
        action1.setDuration(action.getDuration());
        action1.setDurationHour(action.getDurationHour());
        action1.setShortName(action.getShortName());
        action1.setDomaine(action.getDomaine());
        action1.setType(action.getType());
        return action1;
    }

}
