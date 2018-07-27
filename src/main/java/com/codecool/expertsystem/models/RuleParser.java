package com.codecool.expertsystem.models;

import java.util.ArrayList;
import java.util.Arrays;

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 * <h1>RuleParser</h1>
 * Parse xmlDocument , collect data & store it in RuleRepository object
 * @author pkaminski
 * @version 1.0
 */
public class RuleParser extends XMLParser {

    /**
     * Constructor
     * load .xml file & get doc obj
     * @param String xml file path
     */
    public RuleParser(String xmlPath) {
        loadXMLDocument(xmlPath);
    }

    /**
     * Create RuleRepository instance
     * @return RuleRepository
     */
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

    /**
     * Collect data from doc object & create Question object
     * @param xmlRule xml element tag<Rule>
     * @return Question
     */
    private Question parseXmlRuleQuestion(Element xmlRule) {
        String id = xmlRule.getAttribute("id");
        String questionStr = xmlRule.getElementsByTagName("Question").item(0).getTextContent();
        Answer answer = parseXmlRuleAnswer((Element) xmlRule.getElementsByTagName("Answer").item(0));
        return new Question(id, questionStr, answer);
    }

    /**
     * Create Answer object
     * @param xmlAnswer xml element tag<Selection>
     * @return Answer
     */
    private Answer parseXmlRuleAnswer(Element xmlAnswer) {
        NodeList selectionList = xmlAnswer.getElementsByTagName("Selection");
        Answer answer = new Answer();

        for (int i = 0; i < selectionList.getLength(); i++) {
            answer.addValue(getValueObj(selectionList.item(i)));
        }
        return answer;
    }

    /**
     * @param selection xml node tag<Selection>
     * @return Value
     */
    private Value getValueObj(Node selection) {
        NodeList childList = selection.getChildNodes();
        for (int j = 0; j < childList.getLength(); j++) {
            if (childList.item(j) instanceof Element) {
                return getValueInstance((Element)childList.item(j), (Element)selection);
            }
        }
        return null;
    }

    /**
     * Collect data from doc object & create Value object
     * @param child xml element tag<SingleValue> or <MultipleValue>
     * @param parent xml element tag<Selection>
     * @return Value object
     */
    private Value getValueInstance(Element child, Element parent) {
        String attrName = "value";

        if (child.getTagName().equals("SingleValue")) {
            return new SingleValue(child.getAttribute(attrName), (parent.getAttribute(attrName).equals("true")));
        } else if (child.getTagName().equals("MultipleValue")) {
            ArrayList<String> valueList = new ArrayList<String>(Arrays.asList(child.getAttribute(attrName).split(",")));
            return new MultipleValue(valueList, (parent.getAttribute(attrName).equals("true")));
        } else {
            return null;
        }
    }
}
