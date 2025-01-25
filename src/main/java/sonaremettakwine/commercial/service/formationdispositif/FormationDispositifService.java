package sonaremettakwine.commercial.service.formationdispositif;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sonaremettakwine.commercial.dao.action.Action;
import sonaremettakwine.commercial.dao.formationdispositif.FormationDispositif;
import sonaremettakwine.commercial.dao.formationdispositif.FormationDispositifRepository;
import sonaremettakwine.commercial.service.action.ActionService;

import java.util.List;

@Service
@Transactional
public class FormationDispositifService {


    @Autowired
    FormationDispositifRepository formationDispositifRepository;

    @Autowired
    ActionService actionService;

    public List<FormationDispositif> getAll() {
        return formationDispositifRepository.findAll();
    }

    public FormationDispositif getFormationDispositifById(Long id) {
        return formationDispositifRepository.getReferenceById(id);
    }



    public FormationDispositif add(FormationDispositif formationDispositif) {
        return formationDispositifRepository.save(formationDispositif);
    }

    public void delete(FormationDispositif formationDispositif) {
        formationDispositifRepository.delete(formationDispositif);
    }

    public FormationDispositif update(FormationDispositif formationDispositif) {
        FormationDispositif formationDispositif1 = getFormationDispositifById(formationDispositif.getId());
        formationDispositif1.setAction(formationDispositif.getAction());
        formationDispositif1.setModule(formationDispositif.getModule());
        formationDispositif1.setDurationHour(formationDispositif.getDurationHour());
        return formationDispositif1;
    }

    public List<FormationDispositif> getFormationDispositifByActionId(Long id) {
       return formationDispositifRepository.getAllByActionOrderByModuleName(actionService.getActionById(id));
    }
}
