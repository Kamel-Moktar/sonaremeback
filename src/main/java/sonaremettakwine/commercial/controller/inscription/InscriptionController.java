package sonaremettakwine.commercial.controller.inscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sonaremettakwine.commercial.dao.inscription.Inscription;
import sonaremettakwine.commercial.service.inscription.InscriptionService;

import java.util.List;

@RestController
@RequestMapping("/inscription")
public class InscriptionController {

    @Autowired
    InscriptionService comaineService;

    @GetMapping("/all")
    public List<Inscription> getAll(){
        return comaineService.getAll();
    }

    @GetMapping("/allbysession/{sessionId}")
    public List<Inscription> getAllBySession(@PathVariable Long sessionId){
        return comaineService.getAllBySession(sessionId);
    }

    @GetMapping("/allbystagiaire/{stagiaireId}")
    public List<Inscription> getAllByStagiaire(@PathVariable Long stagiaireId){
        return comaineService.getAllByStagiaire(stagiaireId);
    }

    @GetMapping("/byid/{id}")
    public Inscription getById(@PathVariable Long id){
        return comaineService.getInscriptionById(id);
    }


    @PostMapping("/add")
    public Inscription add(@RequestBody Inscription comaine){

        return comaineService.add(comaine);

    }
    @PostMapping("/delete")
    public Inscription delete(@RequestBody  Inscription comaine){
        comaineService.delete(comaine);
        return comaine;
    }

    @PostMapping("/update")
    public Inscription update(@RequestBody  Inscription comaine){
        return  comaineService.update(comaine);

    }

}


