package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/v1/customers")
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "all")
    public List<Customer> getCustomers() {
        return this.customerService.getCustomers();
    }

    @PostMapping
    public void createNewCustomer(@RequestBody Customer customer) {
        System.out.println("POST REQUEST");
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer) {
        System.out.println("UPDATE REQUEST " + customer);
    }

    @DeleteMapping(value = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long id) {
        System.out.println("Delete Request for customer with id "+ id);
    }
}
