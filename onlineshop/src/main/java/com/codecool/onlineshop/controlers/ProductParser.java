package com.codecool.onlineshop.controlers;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import com.codecool.onlineshop.model.Product;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ProductParser{
    String fileName;

    public ProductParser(String fileName){

    }

    public void loadProducts(){

    }

    public void addProduct(Product product){

    }

    public void writeXMLFle(){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBulider = docFactory.newDocumentBuilder();

            Document doc = docBulider.newDocument();
            Element onelineShop = doc.createElement("OnlineShop");
            doc.appendChild(onelineShop);

            





        } catch (ParserConfigurationException pce){
            pce.printStackTrace();

        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

}