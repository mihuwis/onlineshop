package com.codecool.onlineshop.model;

import com.codecool.onlineshop.controlers.IDGenerator;

public class Order implements Orderable{
    
    private int id;
    private String status;
    private IDGenerator idGenerator = new IDGenerator();

    public Order() {
        id = idGenerator.generateID();
    }

    public String getStatus() {
        return status;
    }

    private void setStatus(String newStatus) {
        this.status = newStatus;
    }

    public Integer getID() {
        return id;
    }

    @Override
    public boolean checkout() {
        return true;
    }

    @Override
    public boolean pay() {
        return true;
    }


}