package sonaremettakwine.commercial.controller.inscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sonaremettakwine.commercial.dao.customer.Customer;
import sonaremettakwine.commercial.dao.inscription.Inscription;
import sonaremettakwine.commercial.dao.session.Session;
import sonaremettakwine.commercial.service.customer.CustomerService;
import sonaremettakwine.commercial.service.inscription.InscriptionService;
import sonaremettakwine.commercial.service.session.SessionService;

import java.util.List;

@RestController
@RequestMapping("/inscription")
public class InscriptionController {

    @Autowired
    InscriptionService inscriptionService;

    @Autowired
    CustomerService customerService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/all")
    public List<Inscription> getAll(){
        return inscriptionService.getAll();
    }

    @GetMapping("/allbysession/{sessionId}")
    public List<Inscription> getAllBySession(@PathVariable Long sessionId){
        return inscriptionService.getAllBySession(sessionId);
    }

    @GetMapping("/allbystagiaire/{stagiaireId}")
    public List<Inscription> getAllByStagiaire(@PathVariable Long stagiaireId){
        return inscriptionService.getAllByStagiaire(stagiaireId);
    }

    @GetMapping("/byid/{id}")
    public Inscription getById(@PathVariable Long id){
        return inscriptionService.getInscriptionById(id);
    }


    @PostMapping("/add")
    public Inscription add(@RequestBody Inscription comaine){

        return inscriptionService.add(comaine);

    }
    @PostMapping("/delete")
    public Inscription delete(@RequestBody  Inscription comaine){
        inscriptionService.delete(comaine);
        return comaine;
    }

    @PostMapping("/update")
    public Inscription update(@RequestBody  Inscription comaine){
        return  inscriptionService.update(comaine);

    }

    @GetMapping("/customer/{cId}/{sId}")
    public List<Inscription> getInscriptionByCustomer(@PathVariable  Long cId,@PathVariable  Long sId){
        Customer customer=customerService.getCustomerById(cId);
        Session session=sessionService.getSessionById(sId);
        return inscriptionService.getByStagiaireCustomer(customer,session);
    }
    @GetMapping("/session/{id}")
    public List<Session> getSessionByCustomer(@PathVariable  Long id){
        Customer customer=customerService.getCustomerById(id);
        return inscriptionService.getSessionByCustomer(customer);
    }


}


