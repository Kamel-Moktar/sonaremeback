package sonaremettakwine.commercial.service.domaine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.domaine.Domaine;
import sonaremettakwine.commercial.dao.domaine.DomaineRepository;


import java.util.List;

@Service
@Transactional
public class DomaineService  {

    @Autowired
    DomaineRepository domaineRepository;//

    public List<Domaine> getAll(){

        return domaineRepository.getAllSortByID();

    }

    public Domaine getDomaineById(Long id){
        return domaineRepository.getDomaineById(id);
    }



    public Domaine add(Domaine domaine){
        return domaineRepository.save(domaine);
    }

    public void delete(Domaine domaine){ domaineRepository.delete(domaine);  }

    public Domaine update(Domaine domaine){

        Domaine domaine1=getDomaineById(domaine.getId());
        domaine1.setName(domaine.getName());

        domaine1.setColor(domaine.getColor());
        return domaine1;
    }
}
