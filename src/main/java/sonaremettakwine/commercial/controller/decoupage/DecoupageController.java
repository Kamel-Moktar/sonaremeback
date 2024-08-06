package sonaremettakwine.commercial.controller.decoupage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sonaremettakwine.commercial.dao.decoupage.Decoupage;
import sonaremettakwine.commercial.dao.decoupage.Wilaya;
import sonaremettakwine.commercial.service.decoupage.DecoupageService;

import java.util.List;

@RestController
@RequestMapping("/decoupage")
public class DecoupageController {

    @Autowired
    DecoupageService decoupageService;


    @GetMapping("/wilaya")
    List<Wilaya> getAllWilaya(){
        return decoupageService.getWilaya();
    }
    @GetMapping("/commune/{wilayaName}")
    List<Decoupage> getAllWilaya(@PathVariable String wilayaName){
        return decoupageService.getCommunByWilaya(wilayaName);
    }

}
