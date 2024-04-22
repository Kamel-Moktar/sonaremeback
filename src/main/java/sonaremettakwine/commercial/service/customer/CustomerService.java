package sonaremettakwine.commercial.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sonaremettakwine.commercial.dao.customer.Customer;
import sonaremettakwine.commercial.dao.customer.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;//

    public List<Customer> getAll(){

        return customerRepository.getAllSortByID();

    }

    public Customer getCustomerById(Long id){
        return customerRepository.getReferenceById(id);
    }



    public Customer add(Customer customer){
        return customerRepository.save(customer);
    }

    public void delete(Customer customer){ customerRepository.delete(customer);  }

    public Customer update(Customer customer){
        Customer customer1=getCustomerById(customer.getId());
        customer1.setName(customer.getName());
        customer1.setShortName(customer.getShortName());
        customer1.setRC(customer.getRC());
        customer1.setIF(customer.getIF());
        customer1.setNS(customer.getNS());
        customer1.setNArticle(customer.getNArticle());

        return customer1;
    }
}
