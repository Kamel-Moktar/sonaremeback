package sonaremettakwine.commercial.controller.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sonaremettakwine.commercial.dao.module.Module;
import sonaremettakwine.commercial.service.module.ModuleService;

import java.util.List;

@RestController
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    ModuleService moduleService;

    @GetMapping("/all")
    public List<Module> getAll(){
        return moduleService.getAll();
    }

    @GetMapping("/")
    public List<Module> getAllByNameByBomaine(@RequestParam String name,@RequestParam String domaine){


        return moduleService.getAllByNameByDomain(  "%"+name+'%',"%"+domaine+"%" );
    }


    @GetMapping("/byid/{id}")
    public Module getById(@PathVariable Long id){
        return moduleService.getModuleById(id);
    }


    @PostMapping("/add")
    public Module add(@RequestBody Module module){

        return moduleService.add(module);

    }
    @PostMapping("/delete")
    public Module delete(@RequestBody  Module module){
        moduleService.delete(module);
        return module;
    }

    @PostMapping("/update")
    public Module update(@RequestBody  Module module){
        return  moduleService.update(module);

    }

}
