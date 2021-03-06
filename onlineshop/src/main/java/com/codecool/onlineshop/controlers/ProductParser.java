package com.codecool.onlineshop.controlers;

import java.io.File;
import java.util.List;

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
import com.codecool.onlineshop.model.ProductCategory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ProductParser{
    private String fileXML = "src/main/resources/file.xml";
    List<Product> productList = new Product().getAllProducts();
    List<ProductCategory> productCategoriesList;
    
    public ProductParser(List<ProductCategory> productCategoriesList) {
        this.productCategoriesList = productCategoriesList;
    }

    public void loadProducts(){
        try {
            File productFile = new File(fileXML);
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(productFile);

            doc.getDocumentElement().normalize();
            
            String shopElement = doc.getDocumentElement().getNodeName();

            NodeList productsList = doc.getElementsByTagName("Products");
            NodeList productList = doc.getElementsByTagName("Product");

            for(int i = 0; i < productList.getLength(); i++){
                Node nNode = productList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element) nNode;

                    String idString = eElement.getAttribute("ID");
                    Integer id = Integer.parseInt(idString);
                    String productName = eElement.getElementsByTagName("Name").item(0).getTextContent();
                    String priceString = eElement.getElementsByTagName("Price").item(0).getTextContent();
                    Float price = Float.parseFloat(priceString);
                    String categoryString = eElement.getElementsByTagName("Category").item(0).getTextContent();
                    ProductCategory category = null;

                    for (ProductCategory productCategory : productCategoriesList) {
                        if (productCategory.getCategoryName().equals(categoryString)) {
                            category = productCategory;
                        }
                    }

                    Product product = new Product(id, productName, price, category);
                }
            }

        } catch (Exception err) {
            err.printStackTrace();
        }
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

            for (Product productInList: productList){

                Element product = doc.createElement("Product");
                products.appendChild(product);
    
                Attr id = doc.createAttribute("ID");
                id.setValue(productInList.getProductId().toString());
                product.setAttributeNode(id);
    
                Element name = doc.createElement("Name");
                name.appendChild(doc.createTextNode(productInList.getProductName()));
                product.appendChild(name);
    
                Element price = doc.createElement("Price");
                price.appendChild(doc.createTextNode(productInList.getProductPrice().toString()));
                product.appendChild(price);
    
                Element category = doc.createElement("Category");
                category.appendChild(doc.createTextNode(productInList.getCategoryName()));
                product.appendChild(category);
            }

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fileXML));

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
