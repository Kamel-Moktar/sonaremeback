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
    DomaineService comaineService;

    @GetMapping("/all")
    public List<Domaine> getAll(){
        return comaineService.getAll();
    }

    @GetMapping("/byid/{id}")
    public Domaine getById(@PathVariable Long id){
        return comaineService.getDomaineById(id);
    }


    @PostMapping("/add")
    public Domaine add(@RequestBody Domaine comaine){

        return comaineService.add(comaine);

    }
    @PostMapping("/delete")
    public Domaine delete(@RequestBody  Domaine comaine){
        comaineService.delete(comaine);
        return comaine;
    }

    @PostMapping("/update")
    public Domaine update(@RequestBody  Domaine comaine){
        return  comaineService.update(comaine);

    }

}

