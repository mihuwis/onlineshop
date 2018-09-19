package com.codecool.onlineshop.view;

import main.java.com.codecool.onlineshop.view.TableBuilder;

public class View {
    
    TableBuilder tableBuilder = new TableBuilder(products);

    public void printProductsTable() {
        System.out.println(tableBuilder.getProductsTable());
    }

}