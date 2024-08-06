package sonaremettakwine.commercial.service.decoupage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sonaremettakwine.commercial.dao.decoupage.Decoupage;
import sonaremettakwine.commercial.dao.decoupage.DecoupageRepository;
import sonaremettakwine.commercial.dao.decoupage.Wilaya;

import java.util.List;

@Service
public class DecoupageService {


    @Autowired
    DecoupageRepository wilayaRepository;


    public List<Wilaya> getWilaya() {
        return wilayaRepository.getAllWilaya();
    }

    public List<Decoupage> getCommunByWilaya(String wilayaName) {
        return wilayaRepository.getCommuneByWilaya(wilayaName);
    }

}


