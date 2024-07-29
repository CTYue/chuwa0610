package com.jackpang.xhs.service;

import com.jackpang.xhs.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(Long theId);

    void deleteCustomer(Long theId);

}