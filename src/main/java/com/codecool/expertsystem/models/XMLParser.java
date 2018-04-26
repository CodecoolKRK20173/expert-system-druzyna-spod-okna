package com.codecool.expertsystem.models;

import com.codecool.expertsystem.Main;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.File;

public abstract class XMLParser {

    protected Document doc;

    /**
     * Opens an XML file and constructs document
     * @param xmlPath - String
     */
    public void loadXMLDocument(String xmlPath) {
        try {
            File xmlFile = new File(xmlPath);
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            this.doc = docBuilder.parse(xmlFile);
            this.doc.getDocumentElement().normalize();
        } catch (Exception err) {
            Main.resourcesNotFound();
            err.printStackTrace();
        }
    }

    /**
     * Return constructed XML document
     * @return Document
     */
    public Document getDoc() {
        return this.doc;
    }
}
