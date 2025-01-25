package sonaremettakwine.commercial.service.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.module.Module;
import sonaremettakwine.commercial.dao.module.ModuleRepository;

import java.util.List;

@Service
@Transactional
public class ModuleService {

    @Autowired
    ModuleRepository moduleRepository;//

    public List<Module> getAll(){ return moduleRepository.findAllByOrderByIdDesc();    }

    public List<Module> getAllByNameByDomain(String name,String domaineName){
        return moduleRepository.findByNameLikeAndDomaineNameLikeOrderByIdDesc(name,domaineName);
    }


    public Module getModuleById(Long id){
        return moduleRepository.getReferenceById(id);
    }


    public Module add(Module module){
        return moduleRepository.save(module);
    }

    public void delete(Module module){ moduleRepository.delete(module);  }

    public Module update(Module module){
        Module module1=getModuleById(module.getId());
        module1.setName(module.getName());
        module1.setDurationHour(module.getDurationHour());
        module1.setObjectif(module.getObjectif());
        module1.setDomaine(module.getDomaine());
        return module1;
    }

}

