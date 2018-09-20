package com.codecool.onlineshop.controlers;

import main.java.com.codecool.onlineshop.model.Order;

public class OrderController{

    private Order order = new Order();
    private List<Order> listOfOrders = new ArrayList<>();
    
    public Order createNewOrder() {
        Order newOrder = new Order();
        this.order = newOrder;
        return newOrder;
    }
}
