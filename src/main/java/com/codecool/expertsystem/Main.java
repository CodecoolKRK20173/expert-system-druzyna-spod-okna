package com.codecool.expertsystem;

import com.codecool.expertsystem.models.FactParser;
import com.codecool.expertsystem.models.XMLParser;

public class Main {

    public static void main(String[] args) {
        XMLParser fP = new FactParser("src/main/resources/Facts.xml");
        ((FactParser) fP).getFactRepository();
    }
}
