package com.codecool.onlineshop.controlers;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.codecool.onlineshop.model.Product;

import org.w3c.dom.Attr;
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

    public void serializeProductToFile(){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBulider = docFactory.newDocumentBuilder();

            Document doc = docBulider.newDocument();
            Element onelineShop = doc.createElement("OnlineShop");
            doc.appendChild(onelineShop);

            Element products = doc.createElement("Products");
            onelineShop.appendChild(products);

            Attr category = doc.createAttribute("Category");
            category.setValue("Drugs");
            products.setAttributeNode(category);

            Element product = doc.createElement("Product");
            products.appendChild(product);

            Attr id = doc.createAttribute("ID");
            id.setValue("1");
            product.setAttributeNode(id);

            Element name = doc.createElement("Name");
            name.appendChild(doc.createTextNode("Cocaine"));
            product.appendChild(name);

            Element price = doc.createElement("Price");
            price.appendChild(doc.createTextNode("150,00"));
            product.appendChild(price);

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/file.xml"));

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(source, result);




        } catch (ParserConfigurationException pce){
            pce.printStackTrace();

        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

}