package com.codecool.onlineshop.controlers;

import com.codecool.onlineshop.model.FeaturedProductCategory;
import com.codecool.onlineshop.view.View;

public class ShopController{
    
    private ProductController product;
    private BasketController basket;
    private OrderController order;
    private View view;

    public ShopController(){
        product = new ProductController();
        basket = new BasketController();
        order = new OrderController();
        view = new View();
    }

    public void loadProductsFromFile(String fileName){

    }

    public void saveProductsTo(String fileName){

    }

    public void showTableOfProducts(){

    }

    public void  newOrder(){

    }

    public void exit(){

    }
}