package com.codecool.onlineshop.controlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.codecool.onlineshop.model.Product;
import com.codecool.onlineshop.model.ProductCategory;
import com.codecool.onlineshop.view.View;
import com.codecool.onlineshop.view.View.Menu;
import com.codecool.onlineshop.view.View.Message;
import com.codecool.onlineshop.model.Order;
import com.codecool.onlineshop.model.Basket;
import java.lang.Exception;

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
        setDefaultCategories();
    }

    private void printMainMenu() {
        view.printMenu(Menu.MAIN_MENU);
    }

    private void printOrderMenu() {
        view.printMenu(Menu.ORDER_MENU);
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
            case "4":
                handleNewOrder();
                break;
            case "0":
                saveProductsTo();
                isRunning = false;
            }
        }
    }

    private void setDefaultCategories() {
        String[] categorysNames = {"Drugs", "Armor", "Weapon"};
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

    private void loadProductsFromFile() {
        parser.loadProducts();
    }

    private void saveProductsTo() {
        parser.serializeProductToFile();
    }

    private void showTableOfProducts() {
        view.printProductsTable(product.getAllProducts());
    }

    private void showTableOfBasketProducts() {
        view.printProductsTable(basket.getProductsInBasket());
    }

    private void addProductToTheBasket() {
        view.printMessage(Message.ASK_FOR_ID);
        String userInput = getUserInput();
        try {
            Product productOfInterest = product.findProduct(userInput);
            basket.addProduct(productOfInterest);
        } catch (Exception e) {
            view.printMessage(Message.PRODUCT_NOT_FOUND);
        }
    }

    private void removeProductFromBasket() {
        view.printMessage(Message.ASK_FOR_ID);
        String productID = getUserInput();
        Iterator<Product> productIterator = basket.getProductIterator();
        while (productIterator.hasNext()) {
            if (productIterator.next().getProductId().toString().equals(productID)) {
                productIterator.remove();
            }
        }
    }

    private void removeProductsInBasketFromProductList() {
        for (Product productInBasket : basket.getProductsInBasket()) {
            product.getAllProducts().remove(productInBasket);
        }
    }

    private void checkoutOrder() {
        Order checkoutOrder = order.getLastOrder();
        checkoutOrder.setStatus("WAITING FOR PAYMENT");
    }

    private void handleNewOrder() {
        order.createNewOrder();
        basket.createNewBasket();
        boolean orderPending = true;

        while (orderPending) {
            printOrderMenu();
            String userInput = getUserInput();
            switch (userInput) {
            case "1":
                showTableOfProducts();
                break;
            case "2":
                showTableOfBasketProducts();
                break;
            case "3":
                addProductToTheBasket();
                break;
            case "4":
                removeProductFromBasket();
                break;
            case "5":
                checkoutOrder();
                removeProductsInBasketFromProductList();
                orderPending = false;
                break;
            case "0":
                order.removeLastOrder();
                orderPending = false;
                break;
            }
        }
    }
}
