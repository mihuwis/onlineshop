package com.codecool.onlineshop.controlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.codecool.onlineshop.model.ProductCategory;
import com.codecool.onlineshop.view.View;
import com.codecool.onlineshop.view.View.Menu;
import com.codecool.onlineshop.view.View.Message;

public class ShopController {

    private ProductController product;
    private BasketController basket;
    private OrderController order;
    private ProductParser parser;
    private View view;
    private List<ProductCategory> productCategoryList = new ArrayList<>();

    public ShopController() {
        product = new ProductController();
        basket = new BasketController();
        parser = new ProductParser(productCategoryList);
        view = new View();
        order = new OrderController();
        setDefaultCategorys();
    }

    private void printMainMenu() {
        view.printMenu(Menu.MAIN_MENU);
    }

    public void mainMenuHandler() {
        boolean isRunning = true;
        loadProductsFromFile();
        while (isRunning) {
            printMainMenu();
            String userInput = getUserInput();
            switch (userInput) {
            case "1":
                showTableOfProducts();
                break;
            case "2":
                addNewCategory();
                break;
            case "3":
                createNewProduct();
                break;
            case "0":
                saveProductsTo();
                isRunning = false;
            }
        }
    }

    private void setDefaultCategorys() {
        String[] categorysNames = { "Drugs", "Armor", "Weapon" };
        for (String name : categorysNames) {
            productCategoryList.add(new ProductCategory(name));
        }
    }

    private void addNewCategory() {
        Scanner sc = new Scanner(System.in);
        view.printMessage(Message.ASK_FOR_CATEGORY);
        String newCategoryName = sc.nextLine();
        ProductCategory newProductCategory = new ProductCategory(newCategoryName);
        productCategoryList.add(newProductCategory);
    }

    private void createNewProduct() {
        Scanner sc = new Scanner(System.in);
        String name;
        Float defaultPrice;
        ProductCategory productCategory;

        view.printMessage(Message.ASK_FOR_NAME);
        name = sc.nextLine();
        view.printMessage(Message.ASK_FOR_PRICE);
        defaultPrice = sc.nextFloat();
        view.printMessage(Message.ASK_FOR_CATEGORY);
        view.printCategoryMenu(productCategoryList);
        productCategory = productCategoryList.get(sc.nextInt() - 1);
        product.addProduct(name, defaultPrice, productCategory);

    }

    private String getUserInput() {
        Scanner sc = new Scanner(System.in);
        String userInput = "";
        userInput = sc.nextLine();
        return userInput;
    }

    public void loadProductsFromFile() {
        parser.loadProducts();
    }

    public void saveProductsTo() {
        parser.serializeProductToFile();
    }

    public void showTableOfProducts() {
        view.printProductsTable(product.getAllProducts());
    }

    public void showTableOfBasketProducts() {
        view.printProductsTable(basket.getProductsInBasket());
    }
}
