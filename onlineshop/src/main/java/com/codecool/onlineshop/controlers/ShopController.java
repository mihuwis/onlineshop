package com.codecool.onlineshop.controlers;

import com.codecool.onlineshop.model.FeaturedProductCategory;
import com.codecool.onlineshop.view.View;

public class ShopController{
    
    private ProductController product;
    private BasketController basket;
    private OrderController order;
    private ProductParser parser;
    private View view;

    public ShopController(String fileName){
        product = new ProductController();
        basket = new BasketController();
        parser = new ProductParser(fileName);
        view = new View();
    }

    public void loadProductsFromFile(String fileName){
        parser.loadProducts(fileName);

    }

    public void saveProductsTo(String fileName){
        parser.serializeProductsToFile(fileName);
    }

    public void showTableOfProducts(){
        view.showTableOfProducts();
    }

    public void  newOrder(){
        order = new OrderController();
    }

    public void exit(){
        System.exit(0);
    }
}