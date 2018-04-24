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
            Node node = selectionList.item(i);
            if (node.getNodeName().equals("SingleValue")) {
                System.out.println("SingleValue node");
                answer.addValue(new SingleValue(node.getChildNodes().item(0).getNodeValue(), (node.getNodeValue().equals("true")?true:false)));
            } else if (node.getNodeName().equals("MultipleValue")) {
                System.out.println("MultipleValue");
                String[] array = node.getChildNodes().item(0).getNodeValue().split(",");
                ArrayList<String> valueList = new ArrayList<String>(Arrays.asList(array));
                answer.addValue(new MultipleValue(valueList, (node.getNodeValue().equals("true")?true:false)));
            }
        }
        return answer;
    }
}
