package sonaremettakwine.commercial.service.realisationdispositif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.realisationdispositif.RealisationDispositif;
import sonaremettakwine.commercial.dao.realisationdispositif.RealisationDispositifRepository;

import java.util.List;

@Service
@Transactional
public class RealisationDispositifService{

    @Autowired
    RealisationDispositifRepository realisationDispositifRepository;

    public List<RealisationDispositif> getAll() {
        return realisationDispositifRepository.findAll();
    }

    public RealisationDispositif getRealisationDispositifById(Long id) {
        return realisationDispositifRepository.getReferenceById(id);
    }


    public RealisationDispositif add(RealisationDispositif realisationDispositif) {
        return realisationDispositifRepository.save(realisationDispositif);
    }

    public void delete(RealisationDispositif realisationDispositif) {
        realisationDispositifRepository.delete(realisationDispositif);
    }

    public RealisationDispositif update(RealisationDispositif realisationDispositif) {
        RealisationDispositif realisationDispositif1 = getRealisationDispositifById(realisationDispositif.getId());
        realisationDispositif1.setPhase(realisationDispositif.getPhase());
        realisationDispositif1.setModule(realisationDispositif.getModule());
        realisationDispositif1.setDurationHour(realisationDispositif.getDurationHour());
        return realisationDispositif1;
    }
}
