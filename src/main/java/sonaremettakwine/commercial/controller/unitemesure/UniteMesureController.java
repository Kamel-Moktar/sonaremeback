package sonaremettakwine.commercial.controller.unitemesure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sonaremettakwine.commercial.dao.unitmeasurement.UnitMeasurement;
import sonaremettakwine.commercial.service.unitemesure.UniteMesureService;

import java.util.List;

@RestController
@RequestMapping("/unitemesure")//construction d une resource web
public class UniteMesureController {
    @Autowired
    UniteMesureService uniteMesureService;

    @PostMapping("/all")
   public List<UnitMeasurement> getAll(@RequestBody String name ){
       String name1= !name.equals("*") ?name:"";


        return  uniteMesureService.getAll(name1);
   }



   @PostMapping("/add")
    public UnitMeasurement add(@ RequestBody  UnitMeasurement unitMeasurement){
        return  uniteMesureService.add(unitMeasurement);
   }
    @PostMapping("/kadour")
    public UnitMeasurement delete(@RequestBody  UnitMeasurement unitMeasurement){
        uniteMesureService.delete(unitMeasurement);
        return unitMeasurement;
    }

    @PostMapping("/update")
    public UnitMeasurement update(@RequestBody  UnitMeasurement unitMeasurement){
        return  uniteMesureService.update(unitMeasurement);

    }


}



