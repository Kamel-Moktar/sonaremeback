package sonaremettakwine.commercial.controller.domaine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sonaremettakwine.commercial.dao.domaine.Domaine;
import sonaremettakwine.commercial.service.domaine.DomaineService;


import java.util.List;

@RestController
@RequestMapping("/domaine")
public class DomaineController {


    @Autowired
    DomaineService domaineService;

    @GetMapping("/all")
    public List<Domaine> getAll(){
        return domaineService.getAll();
    }

    @GetMapping("/byid/{id}")
    public Domaine getById(@PathVariable Long id){
        return domaineService.getDomaineById(id);
    }


    @PostMapping("/add")
    public Domaine add(@RequestBody Domaine domaine){

        return domaineService.add(domaine);

    }
    @PostMapping("/delete")
    public Domaine delete(@RequestBody  Domaine domaine){
        domaineService.delete(domaine);
        return domaine;
    }

    @PostMapping("/update")
    public Domaine update(@RequestBody  Domaine domaine){
        return  domaineService.update(domaine);

    }

}

