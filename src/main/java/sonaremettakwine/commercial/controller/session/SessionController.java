package sonaremettakwine.commercial.controller.session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sonaremettakwine.commercial.dao.session.Session;
import sonaremettakwine.commercial.service.session.SessionService;

import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {
    @Autowired
    SessionService sessionService;

    @GetMapping("/all")
    public List<Session> getAll(){
        return sessionService.getAll();
    }

    @GetMapping("/byid/{id}")
    public Session getById(@PathVariable Long id){
        return sessionService.getSessionById(id);
    }


    @PostMapping("/allparam")
    public List<Session> getDebtsParam(@RequestBody Param param) {
        String name=!param.getName().equals("*") ?param.getName():"";
        String theme=!param.getTheme().equals("*") ?param.getTheme():"";
        String date=!param.getDate().equals("*") ?param.getDate():"";

        return sessionService.getAllByNameByThemeByStartDate(name, theme,date);
    }

    @PostMapping("/add")
    public Session add(@RequestBody Session session){

        return sessionService.add(session);

    }
    @PostMapping("/delete")
    public Session delete(@RequestBody  Session session){
        sessionService.delete(session);
        return session;
    }

    @PutMapping("/update")
    public Session update(@RequestBody  Session session){
        return  sessionService.update(session);

    }

}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Param {
    String name;
    String theme;
    String date;
}
