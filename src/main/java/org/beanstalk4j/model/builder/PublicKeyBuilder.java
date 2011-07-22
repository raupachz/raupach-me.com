package org.beanstalk4j.model.builder;

import org.beanstalk4j.model.PublicKey;
import org.jdom.Element;

public class PublicKeyBuilder {
	
	private final PublicKey publicKey;
	
	public PublicKeyBuilder() {
		publicKey = new PublicKey();
	}
	
	public PublicKeyBuilder(Element element) {
		this();
	}
	
	public PublicKey build() {
		return publicKey;
	}
	
	

}
