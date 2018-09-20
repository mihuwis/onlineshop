package com.codecool.onlineshop.controlers;

import com.codecool.onlineshop.model.FeaturedProductCategory;
import com.codecool.onlineshop.model.Product;
import com.codecool.onlineshop.view.View;

public class ShopController{
    
    private ProductController product;
    private BasketController basket;
    private OrderController order;
    private ProductParser parser;
    private Product ghostProduct = new Product();
    private View view;

    public ShopController(String fileName){
        product = new ProductController(ghostProduct);
        basket = new BasketController();
        parser = new ProductParser(fileName);
        view = new View(ghostProduct);
    }

    public void loadProductsFromFile(String fileName){
        parser.loadProducts();

    }

    public void saveProductsTo(String fileName){
        parser.serializeProductToFile();
    }

    public void showTableOfProducts(){
        view.printProductsTable();
    }

    public void  newOrder(){
        order = new OrderController();
    }

    public void exit(){
        System.exit(0);
    }
}