package com.codecool.onlineshop.controlers;

import java.util.List;
import com.codecool.onlineshop.model.Product;
import com.codecool.onlineshop.model.ProductCategory;
import java.lang.Exception;

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

    public void removeProduct(Product product) {
        product.getAllProducts().remove(product);
    }

    public Product findProduct(String ID) throws Exception {
        for (Product productInStock : product.getAllProducts()) {
            if (productInStock.getProductId().toString().equals(ID)) {
                return productInStock;
            }
        } 
        throw new Exception();
    }
}
