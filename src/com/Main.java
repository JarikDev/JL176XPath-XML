package com;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("prop.xml"));

        XPathFactory xpf = XPathFactory.newInstance();
        XPath xp = xpf.newXPath();
        System.out.println(xp.evaluate("/preferences/root/node/node/node/map", document));
        System.out.println(xp.evaluate("/preferences/root/node/node/node/map[2]", document));
        System.out.println(xp.evaluate("/preferences/root/node[2]/map", document));
        System.out.println(xp.evaluate("count(/preferences/root/node)", document));
        System.out.println(xp.evaluate("count(/preferences/root/node)", document));

        NodeList list = (NodeList) xp.evaluate("/preferences/root/node/node/node/map", document, XPathConstants.NODESET);
        Node nl = (Node) xp.evaluate("/preferences/root/node/node/node/map[2]", document, XPathConstants.NODE);
        int count = ((Number) xp.evaluate("count(/preferences/root/node/node/node/map)", document, XPathConstants.NUMBER)).intValue();

        System.out.println(list);
        System.out.println(nl);
        System.out.println( count);
    }
}






































