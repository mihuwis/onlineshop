package com.codecool.onlineshop.view;

import com.codecool.onlineshop.model.Product;

import main.java.com.codecool.onlineshop.view.TableBuilder;

public class View {

    public enum Message {
        ASK_FOR_NAME("Enter product name: "),
        ASK_FOR_ID("Enter product ID: ");

        String message;

        private Message(String message) {
            this.message = message;
        }

        private String getMessage() {
            return message;
        }
    }

    public enum Menu {
        MAIN_MENU(new String[] {"TEMP", "TEMP", "EXIT"}, "TEMPTEMPTEMP");

        String[] menuOptions;
        String title;

        private Menu(String[] menuOptions, String title) {
            this.menuOptions = menuOptions;
            this.title = title;
        }

        private String[] getMenuOptions() {
            return menuOptions;
        }

        private String getTitle() {
            return title;
        }
    }

    public void printProductsTable(List<Product> products) {
        TableBuilder tableBuilder = new TableBuilder(products);
        System.out.println(tableBuilder.getProductsTable());
    }

    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    public void printMenu(Menu menu) {
        String[] mainMenu = menu.getMenuOptions();
        String gameTitle = menu.getTitle();

        System.out.printf("%s\n", gameTitle);
        for (int i=0; i<mainMenu.length; i++) {
            System.out.printf("\t%d) %s\n", i+1, mainMenu[i]);
        }
    }
}
