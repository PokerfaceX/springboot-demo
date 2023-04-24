package com.example.demo.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Primary
public class CustomerFakeRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
            new Customer(1L, "James Bond", "password1", "real1@email.com"),
            new Customer(2L, "Jamilia Ahmed", "password2", "real2@email.com")
        );
    }
}
