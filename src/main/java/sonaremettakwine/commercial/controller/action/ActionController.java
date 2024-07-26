package sonaremettakwine.commercial.controller.action;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sonaremettakwine.commercial.dao.action.Action;
import sonaremettakwine.commercial.service.action.ActionService;

import java.util.List;


@RestController
@RequestMapping("/action")
public class ActionController {

    @Autowired
    ActionService actionService;

    @GetMapping("/all")
    public List<Action> getAll() {
        return actionService.getAll();
    }

    @PostMapping("/allparam")
    public List<Action> getAllParam(@RequestBody Param param) {
        String name=!param.getName().equals("*") ?param.getName():"";
        String domainName=!param.getDomainName().equals("*") ?param.getDomainName():"";
        return actionService.getAllOrderByName(name,domainName);
    }

    @GetMapping("/byid/{id}")
    public Action getById(@PathVariable Long id) {
        return actionService.getActionById(id);
    }

    @PostMapping("/add")
    public Action add(@RequestBody Action action) {
        return actionService.add(action);
    }

    @PostMapping("/delete")
    public Action delete(@RequestBody Action action) {
        actionService.delete(action);
        return action;
    }

    @PutMapping("/update")
    public Action update(@RequestBody Action action) {
        return actionService.update(action);
    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Param {
    String name;
    String domainName;
}
