package org.beanstalk4j.model;

public enum ColorLabel {
	
	RED("label-red"),
	ORANGE("label-orange"),
	YELLOW("label-yellow"),
	GREEN ("label-green"),
	BLUE("label-blue"),
	PINK("label-pink"),
	GREY("label-grey"),
	WHITE("label-white");
	
	private String text;
	
	ColorLabel(String text) {
		this.text = text;
	}
	
	public String toString() {
		return text;
	}
	
	public static ColorLabel parse(String source) {
		for (ColorLabel label : ColorLabel.values()) {
			if (label.toString().equalsIgnoreCase(source)) {
				return label;
			}
		}
		throw new IllegalArgumentException("Unknown color-label: " + source);
	}
	
	

}
