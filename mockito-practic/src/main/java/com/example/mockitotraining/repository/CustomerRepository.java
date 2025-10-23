package com.example.mockitotraining.repository;

import com.example.mockitotraining.model.Customer;

public interface CustomerRepository {
    Customer findById(Long id);
}