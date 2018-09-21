package com.codecool.onlineshop.controlers;

import com.codecool.onlineshop.model.Order;
import java.util.List;
import java.util.ArrayList;

public class OrderController{

    private List<Order> listOfOrders = new ArrayList<>();
    
    public Order createNewOrder() {
        Order newOrder = new Order();
        listOfOrders.add(newOrder);
        return newOrder;
    }

    public Order getLastOrder() {
        return listOfOrders.get(listOfOrders.size()-1);
    }

    public void removeLastOrder() {
        listOfOrders.remove(listOfOrders.size());
    }
}
