package com.jackpang.xhs.service.impl;

import com.jackpang.xhs.dao.CustomerDAO;
import com.jackpang.xhs.dao.CustomerRepository;
import com.jackpang.xhs.entity.Customer;
import com.jackpang.xhs.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(Long theId) {
        return customerRepository.findById(theId).get();
    }

    @Override
    @Transactional
    public void deleteCustomer(Long theId) {
        customerRepository.deleteById(theId);
    }
}