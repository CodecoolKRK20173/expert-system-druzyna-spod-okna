package com.codecool.expertsystem.models;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.File;

public abstract class XMLParser {

    protected Document doc;

    public void loadXMLDocument(String xmlPath) {
        try {
            File xmlFile = new File(xmlPath);
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            this.doc = docBuilder.parse(xmlFile);
            this.doc.getDocumentElement().normalize();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }


    public Document getDoc() {
        return this.doc;
    }
}
