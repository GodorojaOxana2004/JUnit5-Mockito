package com.example.mockitotraining.service;

import com.example.mockitotraining.model.Customer;
import com.example.mockitotraining.repository.CustomerRepository;

public class CustomerService {

    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository){
        this.repository = repository;

    }

    public double calculateDiscount(Long id, double purchaseAmount){
        Customer customer = repository.findById(id);
        String type = customer.getType();

        double discountPercent;

        switch (type){
            case "VIP": discountPercent=0.20;
            break;
            case "REGULAR": discountPercent=0.10;
            break;
            default:
                discountPercent=0;
        }

        return purchaseAmount * (1 -discountPercent);
    }
}
