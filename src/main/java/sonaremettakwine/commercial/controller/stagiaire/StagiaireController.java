package sonaremettakwine.commercial.controller.stagiaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sonaremettakwine.commercial.dao.stagiaire.Stagiaire;
import sonaremettakwine.commercial.service.stagiaire.StagiaireService;

import java.util.List;

@RestController
@RequestMapping("/stagiaire")
public class StagiaireController {
    @Autowired
    StagiaireService stagiaireService;

    @GetMapping("/all")
    public List<Stagiaire> getAll(){
        return stagiaireService.getAll();
    }

    @GetMapping("/byid/{id}")
    public Stagiaire getById(@PathVariable Long id){
        return stagiaireService.getStagiaireById(id);
    }


    @PostMapping("/add")
    public Stagiaire add(@RequestBody Stagiaire stagiaire){

        return stagiaireService.add(stagiaire);

    }
    @PostMapping("/delete")
    public Stagiaire delete(@RequestBody  Stagiaire stagiaire){
        stagiaireService.delete(stagiaire);
        return stagiaire;
    }

    @PostMapping("/update")
    public Stagiaire update(@RequestBody  Stagiaire stagiaire){
        return  stagiaireService.update(stagiaire);

    }

}

