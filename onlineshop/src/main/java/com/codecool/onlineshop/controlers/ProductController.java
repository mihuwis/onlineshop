package com.codecool.onlineshop.controlers;

import java.util.List;

import com.codecool.onlineshop.model.Product;
import com.codecool.onlineshop.model.ProductCategory;

public class ProductController {

    
    private Product product = new Product();


    public List<Product> getAllProducts() {
        return product.getAllProducts();
    }

    public List<Product> getAllProductsBy(ProductCategory productCategory) {
        return product.getAllProductsBy(productCategory);
    }

    public void addProduct(String name, Float defaultPrice, ProductCategory productCategory) {
        Product newProduct = new Product(name, defaultPrice, productCategory);
    }

}
