package mockito.service;

import mockito.model.Customer;
import mockito.repository.CustomerRepository;

public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getOrCreate(String name) {
        Customer customer = customerRepository.getByName(name);
        if (customer == null) {
            customer = new Customer(name);
            return customerRepository.add(customer);
        } else {
            return customer;
        }
    }
}
