package sonaremettakwine.commercial.controller.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sonaremettakwine.commercial.dao.customer.Customer;
import sonaremettakwine.commercial.service.customer.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/byid/{id}")
    public Customer getById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @PostMapping("/allparam")
    public List<Customer> getByName(@RequestBody Param param){

        String name=!param.getName().equals("*") ?param.getName():"";
        String shortName=!param.getName().equals("*") ?param.getShortName():"";
        return customerService.getCustomerByName(param.getName(),param.getShortName());
    }


    @PostMapping("/add")
       public Customer add(@RequestBody Customer customer){

            return customerService.add(customer);

    }
    @PostMapping("/delete")
    public Customer delete(@RequestBody  Customer customer){
        customerService.delete(customer);
        return customer;
    }

    @PostMapping("/update")
    public Customer update(@RequestBody  Customer customer){
        return  customerService.update(customer);

    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Param {
    String name;
    String shortName;
}
