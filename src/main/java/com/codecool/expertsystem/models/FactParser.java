package com.codecool.expertsystem.models;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class FactParser extends XMLParser {

    public FactParser(String xmlPath) {
        loadXMLDocument(xmlPath);
    }
    public void test() {
        System.out.println("Root element: " + getDoc().getDocumentElement().getNodeName());
    }

    public getFactRepository() {
        return new FactRepository(doc);
    }
}
