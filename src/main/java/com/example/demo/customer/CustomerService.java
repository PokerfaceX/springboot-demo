package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        LOGGER.info("getCustomers was called");
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return this.customerRepository.findById(id)
                .orElseThrow(
                        () ->{
                    NotFoundException notFoundException = new NotFoundException("customer with id-" + id + " is not found");
                    LOGGER.error("error in getting customer {}", id, notFoundException);
                    return notFoundException;
                });
    }
}
