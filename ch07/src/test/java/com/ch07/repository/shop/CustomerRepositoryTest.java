package com.ch07.repository.shop;

import com.ch07.entity.shop.Customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void selectCustomers() {
        List<Customer> customers = customerRepository.selectCustomers();
        System.out.println(customers);
    }

    @Test
    public void selectCustomer() {
        Customer customer = customerRepository.selectCustomer("a101");
        System.out.println(customer);
    }

    @Test
    public void selectProjectionCustomer(){
        List<Customer> customers = customerRepository.selectProjectionCustomer();
        System.out.println(customers);
    }

    @Test
    public void searchCustomer() {
        List<Customer> customer11 = customerRepository.searchCustomer("김유신",23);
        List<Customer> customer12 = customerRepository.searchCustomer("강감찬",22);
        List<Customer> customer13 = customerRepository.searchCustomer(null,23);
        List<Customer> customer14 = customerRepository.searchCustomer(null,0);

        System.out.println(customer11);
        System.out.println(customer12);
        System.out.println(customer13);
        System.out.println(customer14);
    }

    @Test
    public void searchKeyword() {
        List<Customer> customers1 = customerRepository.searchKeyword("유신");
        List<Customer> customers2 = customerRepository.searchKeyword("경주");

        System.out.println(customers1);
        System.out.println(customers2);
    }
}