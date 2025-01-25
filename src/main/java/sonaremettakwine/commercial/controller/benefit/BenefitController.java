package sonaremettakwine.commercial.controller.benefit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sonaremettakwine.commercial.dao.benifit.Benefit;
import sonaremettakwine.commercial.dao.benifit.Tva;
import sonaremettakwine.commercial.service.benefit.BenefitService;

import java.util.List;

@RestController
@RequestMapping("/benefit")
public class BenefitController {
    @Autowired
    BenefitService benefitService;


    @GetMapping("/all")
    public List<Benefit> getAll() {
        return benefitService.getAll();
    }



    @GetMapping("/byid/{id}")
    public Benefit getById(@PathVariable Long id) {
        return benefitService.getBenefitById(id);
    }


    @GetMapping("/tva")
    public Tva[] getTva() {
        return Tva.values();
    }



    @PostMapping("/add")
    public Benefit add(@RequestBody Benefit benefit) {
        return benefitService.add(benefit);
    }

    @PostMapping("/delete")
    public Benefit delete(@RequestBody Benefit benefit) {
        benefitService.delete(benefit);
        return benefit;
    }

    @PutMapping("/update")
    public Benefit update(@RequestBody Benefit benefit) {
        return benefitService.update(benefit);
    }
}
