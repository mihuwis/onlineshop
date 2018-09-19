package main.java.com.codecool.onlineshop.view;

import java.util.List;
import java.util.ArrayList;
import com.codecool.onlineshop.model.Product;

public class TableBuilder {
    
    private List<Product> products;
    private String[] titles = {"ID", "Product Name", "Product Category", "Price"};

    public TableBuilder(List<Product> products) {
        this.products = products;
    }

    private String centerString(String string, Integer widthGoal) {
        String centeredString = "";
        int stringLenght = string.length();
        int margin = widthGoal - stringLenght;
        int additionalMargin = 0;

        if (margin%2 != 0) {
            additionalMargin = 1;
        }
        margin /= 2;

        for (int i=0; i < margin; i++) {
            centeredString += " ";
        }

        centeredString += string;

        for (int i=0; i < margin+additionalMargin; i++) {
            centeredString += " ";
        }
        return centeredString;
    }

    private List<Integer> getInitialArrayElementsWidhts(String[] elements) {
        List<Integer> list = new ArrayList<>();
        for (String element : elements) {
            list.add(element.length());
        }
        return list;
    }

    private List<Integer> prepareWidths() {
        List<Integer> widths = getInitialArrayElementsWidhts(titles);

        for (Product product : products) {
            Integer[] widthsOfMethodsLenghts = {product.getProductId().toString().length(),
                                                product.getProductName().length(),
                                                product.getCategoryName().length(),
                                                product.getProductPrice().toString().length()};
            
            for (int i=0; i<widthsOfMethodsLenghts.length; i++) {                      
                if (widthsOfMethodsLenghts[i] > widths.get(i)) {
                    widths.set(i, widthsOfMethodsLenghts[i]);
                }
            }
        }
        return widths;
    }

    public String getProductsTable() {

        StringBuilder productsTableBuilder = new StringBuilder();
        List<Integer> widths = prepareWidths();

        // Printing titles:
        for (int i=0; i<titles.length; i++) {
            productsTableBuilder.append(String.format("|  %s  ", centerString(titles[i], widths.get(i))));
        }
        productsTableBuilder.append(String.format("|\n"));    

        // Printing table content: 
        for (Product product : products) {
            String[] widthsOfMethods = {product.getProductId().toString(),
                                        product.getProductName(),
                                        product.getCategoryName(),
                                        product.getProductPrice().toString()};
            
            for (int i=0; i<widthsOfMethods.length; i++) {
                shapesTableBuilder.append(String.format("|  %s  ", centerString(widthsOfMethods[i], widths.get(i))));
            }
            shapesTableBuilder.append("|\n");
        }
        return shapesTableBuilder.toString();
    }
}
