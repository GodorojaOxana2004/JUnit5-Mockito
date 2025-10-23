package com.example.mockitotraining.model;

public class Customer {
    private Long id;
    private String type;

    public Customer(Long id, String type){
        this.id = id;
        this.type = type;
    }
    public String getType() {
        return type;
    }
}
