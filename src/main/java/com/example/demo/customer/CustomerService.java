package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        log.info("getCustomers was called");
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return this.customerRepository.findById(id)
                .orElseThrow(
                        () ->{
                    NotFoundException notFoundException = new NotFoundException("customer with id-" + id + " is not found");
                    log.error("error in getting customer {}", id, notFoundException);
                    return notFoundException;
                });
    }
}
