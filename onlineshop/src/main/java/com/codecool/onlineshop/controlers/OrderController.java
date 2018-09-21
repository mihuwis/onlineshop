package com.codecool.onlineshop.controlers;

import com.codecool.onlineshop.model.Order;
import java.util.List;
import java.util.ArrayList;

public class OrderController{

    private Order order = new Order();
    private List<Order> listOfOrders = new ArrayList<>();
    
    public Order createNewOrder() {
        Order newOrder = new Order();
        this.order = newOrder;
        return newOrder;
    }
}
