package com.codecool.expertsystem.models;

import java.util.ArrayList;
import java.util.Arrays;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class RuleParser extends XMLParser {

    public RuleParser(String xmlPath) {
        loadXMLDocument(xmlPath);
    }

    public RuleRepository getRuleRepository() {
        RuleRepository ruleRepository = new RuleRepository();
        NodeList nodeList = doc.getElementsByTagName("Rule");
        for (int i = 0; i < nodeList.getLength(); i++) {
        }
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element xmlRule = (Element) nodeList.item(i);
            if (xmlRule.getNodeType() == Node.ELEMENT_NODE) {
                Question parsedQuestion = parseXmlRuleQuestion(xmlRule);
                ruleRepository.addQuestion(parsedQuestion);
            }
        }
        return ruleRepository;
    }

    private Question parseXmlRuleQuestion(Element xmlRule) {
        String id = xmlRule.getAttribute("id");
        String questionStr = xmlRule.getElementsByTagName("Question").item(0).getTextContent();
        Answer answer = parseXmlRuleAnswer((Element) xmlRule.getElementsByTagName("Answer").item(0));
        return new Question(id, questionStr, answer);
    }

    private Answer parseXmlRuleAnswer(Element xmlAnswer) {
        NodeList selectionList = xmlAnswer.getElementsByTagName("Selection");
        Answer answer = new Answer();

        for (int i = 0; i < selectionList.getLength(); i++) {
            NodeList childList = selectionList.item(i).getChildNodes();
            for (int j = 0; j < childList.getLength(); j++) {
                if (childList.item(j) instanceof Element) {
                    Element child = (Element) childList.item(j);
                    Element parent = (Element) selectionList.item(i);
                    String attrName = "value";

                    if (child.getTagName().equals("SingleValue")) {
                        answer.addValue(new SingleValue(child.getAttribute(attrName), (parent.getAttribute(attrName).equals("true")?true:false)));
                    } else if (child.getTagName().equals("MultipleValue")) {
                        ArrayList<String> valueList = new ArrayList<String>(Arrays.asList(child.getAttribute(attrName).split(",")));
                        answer.addValue(new MultipleValue(valueList, (parent.getAttribute(attrName).equals("true")?true:false)));
                    }
                }
            }
        }
        return answer;
    }
}
