package com.example.demo.customer;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CustomerRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        // TODO connect to real db later
        return Arrays.asList(
                new Customer(1L, "need to implement real db", "password", "real@email.com")
        );
    }
}
