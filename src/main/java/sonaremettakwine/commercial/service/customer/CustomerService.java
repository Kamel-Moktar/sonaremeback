package sonaremettakwine.commercial.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.customer.Customer;
import sonaremettakwine.commercial.dao.customer.CustomerRepository;

import java.util.List;

@Service
@Transactional
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;//

    public List<Customer> getAll(){

        return customerRepository.getAllSortByID();

    }

    public Customer getCustomerById(Long id){
        return customerRepository.getCustomerById(id);
    }



    public Customer add(Customer customer){
        return customerRepository.save(customer);
    }

    public void delete(Customer customer){ customerRepository.delete(customer);  }

    public Customer update(Customer customer){

        Customer customer1=getCustomerById(customer.getId());
        customer1.setName(customer.getName());
        customer1.setShortName(customer.getShortName());
        customer1.setNumRc(customer.getNumRc());
        customer1.setIdFiscal(customer.getIdFiscal());
        customer1.setIdStatistic(customer.getIdStatistic());
        customer1.setNumArticle(customer.getNumArticle());
        customer1.setAdresse(customer.getAdresse());
        customer1.setPhoneNumber(customer.getPhoneNumber());
        customer1.setFax(customer.getFax());
        customer1.setExemptFromTax(customer.isExemptFromTax());
        customer1.setSameCompany(customer.isSameCompany());

        return customer1;
    }

    public List<Customer> getCustomerByName(String name,String shortName) {


        return customerRepository.getCustomersByName(name,shortName);
    }
}
