package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CustomerServiceTest {

    private CustomerService underTest;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        this.underTest = new CustomerService(customerRepository);
    }

    @Test
    void getCustomers() {
        // given
        Customer customer = new Customer(
                1L,
                "Jamila",
                "hello",
                "jamila@email.com");
        Customer customer2 = new Customer(
                2L,
                "ali",
                "hello",
                "ali@gmail.com"
        );

        this.customerRepository.saveAll(Arrays.asList(customer, customer2));

        // when
        List<Customer> customerList = underTest.getCustomers();

        // then
        System.out.println("!!!!!!!!!!!!!!!" + customerList);
        assertEquals(2, customerList.size());

    }

    @Test
    void getCustomerById() {
        // given
        Customer customer = new Customer(
                1L,
                "Jamilia",
                "hello",
                "jamila@email.com");

        this.customerRepository.saveAll(Arrays.asList(customer));

        this.customerRepository.save(customer);

        // when
        Customer customerGot = this.underTest.getCustomerById(1L);

        // then
        assertEquals(customer, customerGot);


    }

    @AfterEach
    public void tearDown() {
        this.customerRepository.deleteAll();
    }
}