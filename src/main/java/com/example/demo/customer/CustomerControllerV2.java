package com.example.demo.customer;

import com.example.demo.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "api/v2/customers")
@RestController
public class CustomerControllerV2 {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers() {
        return this.customerService.getCustomers();
    }

    @PostMapping
    public void createNewCustomer(@Valid @RequestBody Customer customer) {
        System.out.println("POST REQUEST");
        System.out.println(customer);
    }

    @GetMapping(path = "{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") Long id) {
        return this.customerService.getCustomerById(id);
    }

    @GetMapping(path = "{customerId}/exception")
    public Customer getCustomerException(@PathVariable("customerId") Long id) {
        throw new ApiRequestException("ApiRequestException for customer " + id);
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
