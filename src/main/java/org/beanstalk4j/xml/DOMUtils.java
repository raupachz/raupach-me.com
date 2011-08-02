package org.beanstalk4j.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DOMUtils {
	
	public static Document buildDocument(InputStream in) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			return builder.parse(in);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String getChildText(Element element, String tag) {
		String value = null;
		NodeList nodeList = element.getElementsByTagName(tag);
		if(nodeList != null && nodeList.getLength() > 0) {
			Element el = (Element)nodeList.item(0);
			if (el.getFirstChild() != null) {
				value = el.getFirstChild().getNodeValue();
			}
		}
		return value;
	}

}
