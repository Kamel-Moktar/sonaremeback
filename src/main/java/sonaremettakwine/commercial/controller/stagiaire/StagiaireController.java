package sonaremettakwine.commercial.controller.stagiaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @PostMapping("/param")
    public List<Stagiaire> getParam(@RequestBody Param param){
        System.out.print(param);
        return stagiaireService.getAllParam(param.getFamilyName(),param.getFirstName(),param.getBirthDay(),param.getCustomer());
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

@Data
@AllArgsConstructor
@NoArgsConstructor
class Param{
     String familyName;
     String firstName;
     String birthDay;
     String customer;
}
