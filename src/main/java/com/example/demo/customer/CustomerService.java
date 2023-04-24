package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> getCustomers() {
        return customerRepo.getCustomers();
    }

    public Customer getCustomerById(Long id) {
        return this.getCustomers()
                .stream()
                . filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("customer with id-" + id + " is not found"));
    }
}
