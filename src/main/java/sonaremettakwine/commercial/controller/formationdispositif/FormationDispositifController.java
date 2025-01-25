package sonaremettakwine.commercial.controller.formationdispositif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sonaremettakwine.commercial.dao.formationdispositif.FormationDispositif;

import sonaremettakwine.commercial.service.formationdispositif.FormationDispositifService;

import java.util.List;

@RestController
@RequestMapping("formation-dispositif")
public class FormationDispositifController {

    @Autowired
    FormationDispositifService formationDispositifService;

    @GetMapping("/all")
    public List<FormationDispositif> getAll() {
        return formationDispositifService.getAll();
    }

    @GetMapping("/byid/{id}")
    public FormationDispositif getById(@PathVariable Long id) {
        return formationDispositifService.getFormationDispositifById(id);
    }

    @GetMapping("/byactionid/{id}")
    public List<FormationDispositif> getByActionId(@PathVariable Long id) {
        return formationDispositifService.getFormationDispositifByActionId(id);
    }


    @PostMapping("/add")
    public FormationDispositif add(@RequestBody FormationDispositif formationDispositif) {

        return formationDispositifService.add(formationDispositif);

    }

    @PostMapping("/delete")
    public FormationDispositif delete(@RequestBody FormationDispositif formationDispositif) {
        formationDispositifService.delete(formationDispositif);
        return formationDispositif;
    }

    @PostMapping("/update")
    public FormationDispositif update(@RequestBody FormationDispositif formationDispositif) {
        return formationDispositifService.update(formationDispositif);

    }
}
