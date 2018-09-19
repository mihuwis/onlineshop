package com.codecool.onlineshop.controlers;

import com.codecool.onlineshop.model.Product;
import com.codecool.onlineshop.model.ProductCategory;

public class ProductController {
    
    private Product product = new Product();
    private ProductParser parser = new Parser();

    public List getAllProducts() {
        product.getAllProducts();
    }

    public List getAllProductsBy(ProductCategory productCategory) {
        product.getAllProductsBy(productCategory);
    }

    public void addProduct(String name, Float defaultPrice, ProductCategory productCategory) {
        Product newProduct = new Product(name, defaultPrice, productCategory);
    }

    public void loadProducts() {

    }

    public void saveProducts() {

    }
}
