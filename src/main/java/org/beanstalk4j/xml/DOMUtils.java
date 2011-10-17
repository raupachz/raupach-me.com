package org.beanstalk4j.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/*
 * Copyright 2011 Björn Raupach

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
public class DOMUtils {
	
    public static boolean isXML(String content) {
    	return content != null && content.startsWith("<?xml");
    }
    
    public static String stripXML(String content) {
    	content = content.replaceAll("\\<.*?\\>", "");
    	content = content.replaceAll("\\n", "");
    	return content;
    }

	
	public static Document buildDocument(InputStream in) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(in);
			document.normalizeDocument();
			in.close();
			return document;
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
