package com.codecool.onlineshop.services;

import com.codecool.onlineshop.view.View;

public class ShopControllerServices {

    private View view;

    public ShopControllerServices() {
        this.view = new View();
    }

    public void printMainMenu() {
        view.printMenu(View.Menu.MAIN_MENU);
    }

    public void printOrderMenu() {
        view.printMenu(View.Menu.ORDER_MENU);
    }
}
