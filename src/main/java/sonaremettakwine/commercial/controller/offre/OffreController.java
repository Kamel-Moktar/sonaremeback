package sonaremettakwine.commercial.controller.offre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import sonaremettakwine.commercial.dao.offre.Offre;

import sonaremettakwine.commercial.dao.proforma.Proforma;
import sonaremettakwine.commercial.service.offre.OffreService;
import sonaremettakwine.commercial.service.proforma.ProformaService;

import java.util.List;
@RestController
@RequestMapping("/offre")
public class OffreController {
    @Autowired
    OffreService offreService;
    @Autowired
    ProformaService proformaService;

    @GetMapping("/byproforma/{id}")
    List<Offre> getOffreByProforma(@PathVariable Long id){
        Proforma proforma= proformaService.getProformaById(id);
        return offreService.getOffreByProforma(proforma);
    }

    @PostMapping("/byproformabytva")
    double getOffreByProformaByTva(@RequestBody Param param){
        Proforma proforma= proformaService.getProformaById(param.getProformaId());
        return offreService.getTotalTva(proforma,param.getTauxTva());
    }

    @GetMapping("/byid/{id}")
    Offre getOffreById(@PathVariable Long id){
        return offreService.getOffreById(id);
    }
    @PostMapping("/add")
    Offre add(@RequestBody Offre offre){
        return offreService.add(offre);
    }

    @PostMapping("/delete")
    Offre delete(@RequestBody Offre offre){
        offreService.delete(offre);
        return offre;
    }

    @PostMapping("/update")
    Offre update(@RequestBody  Offre offre){
        return  offreService.update(offre) ;
    }

}
@Data
@AllArgsConstructor @NoArgsConstructor
class Param {
    Long proformaId;
    double tauxTva;
}
