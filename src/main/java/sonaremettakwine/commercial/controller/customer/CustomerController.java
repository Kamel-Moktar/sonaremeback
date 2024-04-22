package sonaremettakwine.commercial.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
