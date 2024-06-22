package sonaremettakwine.commercial.controller.proforma;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sonaremettakwine.commercial.dao.proforma.Proforma;
import sonaremettakwine.commercial.service.proforma.ProformaService;

import java.util.List;
@RestController
@RequestMapping("/proforma")
public class ProformaController {

    @Autowired
    ProformaService proformaService;


    @GetMapping("/all")
    public List<Proforma> getAll() {
        return proformaService.getAll();
    }

    @GetMapping("/debts")
    public List<Proforma> getDebts() {
        return proformaService.getDebts();
    }

    @PostMapping("/debtsparam")
    public List<Proforma> getDebtsParam(@RequestBody sonaremettakwine.commercial.controller.proforma.Param param) {
        String number=!param.getNumber().equals("*") ?param.getNumber():"";
        String shortName=!param.getShortName().equals("*") ?param.getShortName():"";
        String date=!param.getDate().equals("*") ?param.getDate():"";

        return proformaService.getDebtsByNumberByCustomerByDate(number,shortName,date);
    }
    @PostMapping("/allparam")
    public List<Proforma> getAllParam(@RequestBody sonaremettakwine.commercial.controller.proforma.Param param) {
        String number=!param.getNumber().equals("*") ?param.getNumber():"";
        String shortName=!param.getShortName().equals("*") ?param.getShortName():"";
        String date=!param.getDate().equals("*") ?param.getDate():"";

        return proformaService.getAllByNumberByCustomerByDate(number,shortName,date);
    }
    @GetMapping("/byid/{id}")
    public Proforma getProformaById(@PathVariable Long id) {
        return proformaService.getProformaById(id);
    }


    @PostMapping("/add")
    public Proforma add(@RequestBody Proforma proforma) {
        return proformaService.add(proforma);
    }


    @PostMapping("/delete")
    public Proforma delete(@RequestBody Proforma proforma) {
        proformaService.delete(proforma);
        return proforma;
    }

    @PostMapping("/update")
    public Proforma update(@RequestBody Proforma proforma) {
        return proformaService.update(proforma);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Param {
    String number;
    String shortName;
    String date;
}

