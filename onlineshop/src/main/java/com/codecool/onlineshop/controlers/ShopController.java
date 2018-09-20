package com.codecool.onlineshop.controlers;

import com.codecool.onlineshop.model.FeaturedProductCategory;
import com.codecool.onlineshop.model.Product;
import com.codecool.onlineshop.view.View;
import com.codecool.onlineshop.view.View.Menu;

public class ShopController {

    private ProductController product;
    private BasketController basket;
    private OrderController order;
    private ProductParser parser;
    private View view;
    


    public ShopController(){
        product = new ProductController();
        basket = new BasketController();
        parser = new ProductParser();
        view = new View();
        order = new OrderController();
    }

    public void loadProductsFromFile(String fileName) {
        parser.loadProducts();
    }

    public void saveProductsTo(String fileName) {
        parser.serializeProductToFile();
    }


    public void showTableOfProducts(){
        view.printProductsTable(product.getAllProducts());
    }

    public void showTableOfBasketProducts() {
        view.printProductsTable(basket.getProducts());
    }

    public void newOrder(){

    }

    public void exit() {
        System.exit(0);
    }
}