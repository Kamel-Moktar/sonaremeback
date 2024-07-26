package sonaremettakwine.commercial.controller.phase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.phase.Phase;
import sonaremettakwine.commercial.dao.session.Session;
import sonaremettakwine.commercial.service.phase.PhaseService;
import sonaremettakwine.commercial.service.session.SessionService;

import java.util.List;

@RestController
@RequestMapping("/phase")
public class PhaseController {
    @Autowired
    PhaseService phaseService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/all")
    public List<Phase> getAll(){
        return phaseService.getAll();
    }

    @GetMapping("/allbysession/{sessionId}")
    public List<Phase> getAllBysession(@PathVariable Long sessionId){

        Session session=sessionService.getSessionById(sessionId);
        return phaseService.getAllBySession(session);
    }




    @GetMapping("/byid/{id}")
    public Phase getById(@PathVariable Long id){
        return phaseService.getPhaseById(id);
    }


    @PostMapping("/add")
    public Phase add(@RequestBody Phase phase){

        return phaseService.add(phase);

    }
    @PostMapping("/delete")
    public Phase delete(@RequestBody  Phase phase){
        phaseService.delete(phase);
        return phase;
    }

    @PostMapping("/update")
    public Phase update(@RequestBody  Phase phase){
        return  phaseService.update(phase);

    }



}

