package com.codecool.onlineshop.controlers;

import com.codecool.onlineshop.model.FeaturedProductCategory;
import com.codecool.onlineshop.model.Product;
import com.codecool.onlineshop.view.View;

public class ShopController {

    private ProductController product;
    private BasketController basket;
    private OrderController order;
    private ProductParser parser;
    private View view;
    private String fileXML = ""; 


    public ShopController(){
        product = new ProductController(ghostProduct);
        basket = new BasketController();
        parser = new ProductParser(fileXML);
        view = new View();
        order = new OrderController();
    }

    public void loadProductsFromFile(String fileName) {
        parser.loadProducts();
    }

    public void saveProductsTo(String fileName) {
        parser.serializeProductToFile();
    }

<<<<<<< HEAD
    public void showTableOfProducts() {
        view.printProductsTable();
    }

    public void newOrder() {
        order = new OrderController();
=======
    public void showTableOfProducts(){
        view.printProductsTable(product.getAllProducts());
    }

    public void showTableOfBasketProducts() {
        view.printProductsTable(basket.getProducts());
    }

    public void newOrder(){

>>>>>>> 16f07fcc7fc5f86c7f29de3f5e3494f074669ff1
    }

    public void exit() {
        System.exit(0);
    }
}