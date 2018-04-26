package com.codecool.expertsystem.models;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.List;
import java.util.ArrayList;

public class FactParser extends XMLParser {
    /**
     *
     * @param xmlPath - String, path of XML file
     */
    public FactParser(String xmlPath) {
        loadXMLDocument(xmlPath);
    }

    /**
     * Creates FactRepository and adds to it Facts parsed from XML document
     * @return FactRepository
     */
    public FactRepository getFactRepository() {
        FactRepository factRepository = new FactRepository();
        NodeList nodeList = doc.getElementsByTagName("Fact");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element xmlFact = (Element) nodeList.item(i);
            if (xmlFact.getNodeType() == Node.ELEMENT_NODE) {
                Fact parsedFact = parseXmlFactToObject(xmlFact);
                factRepository.addFact(getSettedFactValues(xmlFact, parsedFact));
            }
        }
        return factRepository;
    }

    /**
     * Parse XML nodes to Fact
     * @param xmlFact - Element
     * @return Fact
     */
    private Fact parseXmlFactToObject(Element xmlFact) {
        Element description = (Element) xmlFact.getElementsByTagName("Description").item(0);
        return new Fact(xmlFact.getAttribute("id"), description.getAttribute("value"));
    }

    /**
     * Parse XML fact values to Fact values and assign them to Fact
     * @param xmlFact - Element
     * @param parsedFact - Fact
     * @return Fact
     */
    private Fact getSettedFactValues(Element xmlFact, Fact parsedFact) {
        Element evals = (Element) xmlFact.getElementsByTagName("Evals").item(0);
        for (int j = 0; j < evals.getElementsByTagName("Eval").getLength(); j++) {
            Element eval = (Element) evals.getElementsByTagName("Eval").item(j);
            String booleanValue = eval.getTextContent();
            parsedFact.setFactValueById(eval.getAttribute("id"), Boolean.valueOf(booleanValue));
        } return parsedFact;
    }
}
