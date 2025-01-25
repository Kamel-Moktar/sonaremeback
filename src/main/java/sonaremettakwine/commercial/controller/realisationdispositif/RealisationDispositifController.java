package sonaremettakwine.commercial.controller.realisationdispositif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sonaremettakwine.commercial.dao.realisationdispositif.RealisationDispositif;

import sonaremettakwine.commercial.service.realisationdispositif.RealisationDispositifService;

import java.util.List;

@RestController
@RequestMapping("realisation-dispositif")
public class RealisationDispositifController {

    @Autowired
    RealisationDispositifService realisationDispositifService;

    @GetMapping("/all")
    public List<RealisationDispositif> getAll(){
        return realisationDispositifService.getAll();
    }

    @GetMapping("/byid/{id}")
    public RealisationDispositif getById(@PathVariable Long id){
        return realisationDispositifService.getRealisationDispositifById(id);
    }


    @PostMapping("/add")
    public RealisationDispositif add(@RequestBody RealisationDispositif realisationDispositif){

        return realisationDispositifService.add(realisationDispositif);

    }
    @PostMapping("/delete")
    public RealisationDispositif delete(@RequestBody  RealisationDispositif realisationDispositif){
        realisationDispositifService.delete(realisationDispositif);
        return realisationDispositif;
    }

    @PostMapping("/update")
    public RealisationDispositif update(@RequestBody  RealisationDispositif realisationDispositif){
        return  realisationDispositifService.update(realisationDispositif);

    }
}
